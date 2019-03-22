/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.controllers.accounts;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thang.daos.accounts.AccountDAO;
import thang.dtos.accounts.AccountDTO;
import thang.dtos.accounts.AccountInvalid;

/**
 *
 * @author Thang
 */
public class RegisterController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String ADMIN = "login.jsp";
    private static final String USER = "insert_user.jsp";
    private static final String INVALID = "register.jsp";

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
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            int roleId = Integer.parseInt(request.getParameter("roleId"));
            boolean valid = true;

            // validation
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
                AccountDAO dao = new AccountDAO();
                AccountDTO dto = new AccountDTO(username, roleId);
                dto.setPassword(password);
                boolean success = dao.register(dto);
                if (success) {
                    if (roleId == 1) {
                        url = ADMIN;
                    } else if (roleId == 2){
                        url = USER;
                    }
                    request.setAttribute("username", username);
                } else {
                    request.setAttribute("ERROR", "Register failed");
                }
            } else {
                url = INVALID;
                request.setAttribute("INVALID", invalidObj);
            }
        } catch (SQLException e) {
            AccountInvalid invalidObj = new AccountInvalid();
            invalidObj.setUsernameInvalid("Username has already been used");
            request.setAttribute("INVALID", invalidObj);
            url = INVALID;
        } catch (Exception e) {
            log("ERROR at RegisterController: " + e.getMessage());
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
