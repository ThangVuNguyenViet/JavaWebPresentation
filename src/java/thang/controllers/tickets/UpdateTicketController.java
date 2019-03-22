/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.controllers.tickets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thang.daos.tickets.TicketDAO;
import thang.dtos.tickets.TicketDTO;
import thang.dtos.tickets.TicketInvalid;

/**
 *
 * @author Thang
 */
public class UpdateTicketController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "SearchTicketController";
    private static final String INVALID = "update_ticket.jsp";

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
            TicketDAO dao = new TicketDAO();
            int ticketId = Integer.parseInt(request.getParameter("txtTicketId"));
            int tourId = Integer.parseInt(request.getParameter("txtTourId"));
            String startDate = request.getParameter("txtStartDate");
            String priceAdultStr = request.getParameter("txtPriceAdult");
            String priceChildStr = request.getParameter("txtPriceChild");
            String ticketLeftStr = request.getParameter("txtTicketLeft");
            //Validation
            TicketInvalid invalidObj = new TicketInvalid();
            boolean valid = true;
            if (priceAdultStr.isEmpty()) {
                valid = false;
                invalidObj.setPriceAdultInvalid("Ticket Adult Price cannot be empty");
            }
            if (priceChildStr.isEmpty()) {
                valid = false;
                invalidObj.setPriceAdultInvalid("Ticket Child Price cannot be empty");
            }
            if (ticketLeftStr.isEmpty()) {
                valid = false;
                invalidObj.setPriceAdultInvalid("Ticket Left cannot be empty");
            }
            if (!priceAdultStr.matches("\\d+000")) {
                valid = false;
                invalidObj.setPriceAdultInvalid("Ticket Adult Price must be a positive number and in thoundsand unit only");
            }
            if (!priceChildStr.matches("\\d+000")) {
                valid = false;
                invalidObj.setPriceAdultInvalid("Ticket Child Price must be a positive number and in thoundsand unit only");
            }
            if (!ticketLeftStr.matches("\\d+")) {
                valid = false;
                invalidObj.setPriceAdultInvalid("Ticket Left must be a positive number");
            }

            if (valid) {
                int priceAdult = Integer.parseInt(priceAdultStr);
                int priceChild = Integer.parseInt(priceChildStr);
                int ticketLeft = Integer.parseInt(ticketLeftStr);
                TicketDTO dto = new TicketDTO(ticketId, tourId, startDate, priceAdult, priceChild, ticketLeft);
                boolean check = dao.update(dto);
                if (check) {
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "Update Ticket Failed");
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
