/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.controllers.books;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thang.daos.accounts.UserDAO;
import thang.daos.books.BookDAO;
import thang.daos.tickets.TicketDAO;
import thang.dtos.books.BookDTO;
import thang.dtos.books.BookInvalid;

/**
 *
 * @author Thang
 */
public class InsertBookController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "user.jsp";
    private static final String INVALID = "book_ticket.jsp";

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
            int ticketId = Integer.parseInt(request.getParameter("cbxTicketId"));
            String username = request.getParameter("cbxUsername");
            int adultQuant = Integer.parseInt(request.getParameter("txtAdultQuant"));;
            int childQuant = Integer.parseInt(request.getParameter("txtChildQuant"));
            //Validation
            BookInvalid invalidObj = new BookInvalid();
            boolean valid = true;
            BookDAO dao = new BookDAO();
            TicketDAO ticketDAO = new TicketDAO();
            // handle if ticketLeft is available
            int ticketLeft = ticketDAO.findTicketLeftByTicketId(ticketId);
            if ((adultQuant + childQuant) > ticketLeft) {
                valid = false;
                invalidObj.setAdultQuantInvalid("There are only " + ticketLeft + " ticket(s) left");
            }
            if ((adultQuant + childQuant) == 0) {
                valid = false;
                invalidObj.setAdultQuantInvalid("Total Quantity cannot be 0");
            }
            if (adultQuant == 0 && !dao.checkIfAdultUserHasBooked(username, ticketId)) {
                valid = false;
                invalidObj.setAdultQuantInvalid("You must have booked an adult ticket before the child ticket");
            }
            if (valid) {
                BookDTO dto = new BookDTO(ticketId, adultQuant, childQuant, username);
                boolean check = dao.insert(dto);
                if (check) {
                    url = SUCCESS;
                    UserDAO userDAO = new UserDAO();
                    userDAO.removeCart((String) request.getSession().getAttribute("USERNAME"), ticketId);
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
