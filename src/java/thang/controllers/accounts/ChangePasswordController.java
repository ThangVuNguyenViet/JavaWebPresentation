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
import thang.dtos.accounts.ChangePasswordInvalid;

/**
 *
 * @author Thang
 */
public class ChangePasswordController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "user.jsp";
    private static final String INVALID = "change_password.jsp";
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
            AccountDAO dao = new AccountDAO();
            String username = (String) request.getSession().getAttribute("USERNAME");
            String oldPassword = request.getParameter("txtOldPassword");
            String newPassword = request.getParameter("txtNewPassword");
            String confirm = request.getParameter("txtConfirm");
            // validation
            boolean valid = true;
            ChangePasswordInvalid invalidObj = new ChangePasswordInvalid();
            if (!confirm.equals(newPassword)) {
                invalidObj.setConfirmPasswordInvalid("Confirm password does not match");
                valid = false;
            }
            if (oldPassword.length() == 0) {
                invalidObj.setOldPasswordInvalid("Old Password can't be blank");
                valid = false;
            }
            if (confirm.length() == 0) {
                invalidObj.setConfirmPasswordInvalid("Confirm can't be blank");
                valid = false;
            }
            if (newPassword.length() == 0) {
                invalidObj.setNewPasswordInvalid("New Password can't be blank");
                valid = false;
            }
            if (oldPassword.length() != 0 && dao.checkLogin(username, oldPassword) != 2) {
                invalidObj.setOldPasswordInvalid("Old Password is incorrect");
                valid = false;
            }
            if (valid) {
                if (dao.changePassword(username, newPassword)) {
                    url = SUCCESS;
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
