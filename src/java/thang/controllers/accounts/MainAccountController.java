/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.controllers.accounts;

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
public class MainAccountController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "LoginController";
    private static final String REGISTER = "RegisterController";
    private static final String CHANGE_PASSWORD = "ChangePasswordController";
    private static final String UPDATE = "UpdateController";
    private static final String EDIT = "EditController";
    private static final String DELETE = "DeleteController";
    private static final String SEARCH = "SearchController";
    private static final String INSERT = "InsertController";
    private static final String VIEW = "ViewUserController";
    private static final String LOGOUT = "LogOutController";

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
        String url = ERROR;
        response.setContentType("text/html;charset=UTF-8");
        try {
            switch (request.getParameter("action")) {
                case "Login":
                    url = LOGIN;
                    break;
                case "Search":
                    url = SEARCH;
                    break;
                case "Edit":
                    url = EDIT;
                    break;
                case "Delete":
                    url = DELETE;
                    break;
                case "Update":
                    url = UPDATE;
                    break;
                case "Register":
                    url = REGISTER;
                    break;
                case "Change Password":
                    url = CHANGE_PASSWORD;
                    break;
                case "Insert":
                    url = INSERT;
                    break;
                case "View":
                    url = VIEW;
                    break;
                case "Log Out":
                    url = LOGOUT;
                    break;
            }
        } catch (Exception e) {
            log("ERROR at MainAccountController: " + e.getMessage());
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
