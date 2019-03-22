/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.controllers.tours;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import thang.daos.tours.TourDAO;
import thang.dtos.tours.TourDTO;
import thang.dtos.tours.TourInvalid;

/**
 *
 * @author Thang
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class UpdateTourController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "SearchTourController";
    private static final String INVALID = "update_tour.jsp";

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
            int tourId = Integer.parseInt(request.getParameter("txtTourId"));
            String tourName = request.getParameter("txtTourName");
            String tourDurationStr = request.getParameter("txtTourDuration");
            String tourOrigin = request.getParameter("cbxTourOrigin");
            String tourDes = request.getParameter("cbxTourDes");
            String description = request.getParameter("txtDescription");
            Part filePart = request.getPart("chooseImg");
            boolean emptyFile = filePart.getSubmittedFileName().isEmpty();
            String imgUrl;
            if (!emptyFile) {
                imgUrl = "img" + File.separator + filePart.getSubmittedFileName();
            } else {
                imgUrl = request.getParameter("imgUrl");
            }
            //Validation
            TourInvalid invalidObj = new TourInvalid();
            boolean valid = true;
            if (!tourDurationStr.matches("\\d+")) {
                valid = false;
                invalidObj.setTourDurationInvalid("Tour Duration must be a positive number");
            }
            if (tourName.isEmpty()) {
                valid = false;
                invalidObj.setTourNameInvalid("Tour Name cannot be empty");
            }
            if (tourDurationStr.isEmpty()) {
                valid = false;
                invalidObj.setTourDurationInvalid("Tour Duration cannot be empty");
            }
            if (valid) {
                TourDTO dto = new TourDTO(tourId, tourName, tourOrigin, tourDes, Integer.parseInt(tourDurationStr), description, imgUrl);
                TourDAO dao = new TourDAO();
                boolean check = dao.update(dto);
                if (check) {
                    if (!emptyFile) {
                        String uploadPath = getServletContext().getRealPath("/") + "img";
                        File uploadDir = new File(uploadPath);
                        if (!uploadDir.exists()) {
                            uploadDir.mkdir();
                        }
                        filePart.write(uploadPath + File.separator + filePart.getSubmittedFileName());
                    }
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "Update Tour Failed");
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
