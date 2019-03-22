/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.controllers.accounts;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thang.daos.accounts.AccountDAO;
import thang.daos.accounts.UserDAO;
import thang.dtos.accounts.AccountInvalid;

/**
 *
 * @author Thang
 */
public class LoginController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String ADMIN = "admin.jsp";
    private static final String USER_OK = "user.jsp";
    private static final String USER_NOT_OK = "insert_user.jsp";
    private static final String INVALID = "login.jsp";

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
            AccountDAO accountDAO = new AccountDAO();
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");

            // validation
            boolean valid = true;
            AccountInvalid invalidObj = new AccountInvalid();
            if (username.length() == 0) {
                invalidObj.setUsernameInvalid("Username can't be blank");
                valid = false;
            }
            if (password.length() == 0) {
                invalidObj.setPasswordInvalid("Password can't be blank");
                valid = false;
            }

            if (valid) {
                int roleId = accountDAO.checkLogin(username, password);
                switch (roleId) {
                    case 0:
                        url = INVALID;
                        invalidObj.setPasswordInvalid("Incorrect username or password");
                        request.setAttribute("INVALID", invalidObj);
                        break;
                    case 1:
                        url = ADMIN;
                        break;
                    case 2:
                        UserDAO userDAO = new UserDAO();
                        if (userDAO.checkIfUserHasProfile(username)) {
                            url = USER_OK;
                        } else {
                            url = USER_NOT_OK;
                            request.setAttribute("username", username);
                        }
                        request.getSession().setAttribute("USERNAME", username);
                        break;
                    default:
                        request.setAttribute("ERROR", "Role not supported");
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
