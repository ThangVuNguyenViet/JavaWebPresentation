/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.controllers.users;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thang.daos.books.BookDAO;
import thang.daos.tickets.TicketDAO;
import thang.dtos.books.BookDTO;
import thang.dtos.books.BookInvalid;

/**
 *
 * @author Thang
 */
public class CompleteBookController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "user.jsp";
    private static final String INVALID = "BookTicketController";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            int ticketId = Integer.parseInt(request.getParameter("ticketId"));
            String username = request.getParameter("txtUsername");
            String adultQuantStr = request.getParameter("txtAdultQuant");
            String childQuantStr = request.getParameter("txtChildQuant");
            int adultQuant = 0, childQuant = 0;
            //Validation
            BookInvalid invalidObj = new BookInvalid();
            BookDAO dao = new BookDAO();
            boolean valid = true;
            boolean isNum = true;
            if (!childQuantStr.matches("\\d+")) {
                valid = false;
                isNum = false;
                invalidObj.setChildQuantInvalid("Child Quantity must be an positive number");
            }
            if (!adultQuantStr.matches("\\d+")) {
                valid = false;
                isNum = false;
                invalidObj.setAdultQuantInvalid("Adult Quantity must be an positive number");
            }

            if (isNum) {
                adultQuant = Integer.parseInt(adultQuantStr);
                childQuant = Integer.parseInt(childQuantStr);
                int quantity = adultQuant + childQuant;
                // handle if ticketLeft is available
                TicketDAO ticketDAO = new TicketDAO();
                int ticketLeft = ticketDAO.findTicketLeftByTicketId(ticketId);
                if (quantity > ticketLeft) {
                    valid = false;
                    invalidObj.setAdultQuantInvalid("There are only " + ticketLeft + " ticket(s) left");
                }
                if (quantity == 0) {
                    valid = false;
                    invalidObj.setAdultQuantInvalid("Quantity cannot be 0");
                }
                if (!dao.checkIfAdultUserHasBooked(username, ticketId) && childQuant > 0 && adultQuant == 0) {
                    valid = false;
                    invalidObj.setAdultQuantInvalid("You cannot book a child ticket without having booked an adult ticket");
                }
            }

            if (valid) {

                BookDTO dto = new BookDTO(ticketId, adultQuant, childQuant, username);
                boolean check = dao.insert(dto);
                if (check) {
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "Insert Book Failed");
                }
            } else {
                url = INVALID;
                request.setAttribute("INVALID", invalidObj);
            }
        } catch (Exception e) {
            log("ERROR at " + getClass().getSimpleName() + ": " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
