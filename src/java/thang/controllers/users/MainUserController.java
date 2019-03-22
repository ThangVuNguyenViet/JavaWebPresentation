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

/**
 *
 * @author Thang
 */
public class MainUserController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SEARCH = "UserSearchTourController";
    private static final String ADD_TO_CART = "AddToCartController";
    private static final String BOOK_TICKET = "BookTicketController";
    private static final String VIEW_TICKET = "UserViewTicketController";
    private static final String VIEW_CART = "UserViewCartController";
    private static final String REMOVE_CART = "RemoveCartController";
    private static final String COMPLETE = "CompleteBookController";

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
            switch (request.getParameter("action")) {
                case "View Ticket":
                    url = VIEW_TICKET;
                    break;
                case "View Cart":
                    url = VIEW_CART;
                    break;
                case "Search":
                    url = SEARCH;
                    break;
                case "Add To Cart":
                    url = ADD_TO_CART;
                    break;
                case "Remove Cart":
                    url = REMOVE_CART;
                    break;
                case "Book Ticket":
                    url = BOOK_TICKET;
                    break;
                case "Complete":
                    url = COMPLETE;
                    break;
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
