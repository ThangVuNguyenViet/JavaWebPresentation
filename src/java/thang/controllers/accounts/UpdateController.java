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
import thang.daos.accounts.UserDAO;
import thang.dtos.accounts.UserDTO;
import thang.dtos.accounts.UserInvalid;

/**
 *
 * @author Thang
 */
public class UpdateController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "user.jsp";
    private static final String INVALID = "update_user.jsp";

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
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String username = request.getParameter("txtUsername");
            String fullname = request.getParameter("txtFullname");
            int yob = Integer.parseInt(request.getParameter("cbxYob"));
            boolean gender = Boolean.parseBoolean(request.getParameter("rbnGender"));
            String email = request.getParameter("txtEmail");
            String phone = request.getParameter("txtPhone");
            String address = request.getParameter("txtAddress");
            UserDTO dto = new UserDTO(username, fullname, phone, email, address, yob, gender);
            boolean valid = true;

            // validation
            UserInvalid invalidObj = new UserInvalid();
            if (fullname.length() == 0) {
                invalidObj.setFullnameInvalid("Fullname can't be blank");
                valid = false;
            }
            if (email.length() == 0) {
                invalidObj.setEmailInvalid("Email can't be blank");
                valid = false;
            }
            if (phone.length() == 0) {
                invalidObj.setPhoneInvalid("Phone Number can't be blank");
                valid = false;
            }
            if (address.length() == 0) {
                invalidObj.setAddressInvalid("Password can't be blank");
                valid = false;
            }

            if (valid) {
                UserDAO dao = new UserDAO();
                boolean success = dao.update(dto);
                if (success) {
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "Update failed");
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
