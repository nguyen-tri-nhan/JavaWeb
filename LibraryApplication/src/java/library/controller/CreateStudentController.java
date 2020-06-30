/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import library.daos.UserDAO;
import library.dtos.ErrorUserDTO;
import library.dtos.UserDTO;

/**
 *
 * @author Lenovo
 */
public class CreateStudentController extends HttpServlet {

    private static final String SUCCESS = "login.html";
    private static final String ERROR = "register.jsp";

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
            ErrorUserDTO errorDTO = new ErrorUserDTO("", "", "", "", "");
            boolean check = true;
            String id = request.getParameter("txtStudentID");
            String fullName = request.getParameter("txtFullName");
            String roleid = "3";
            String password = request.getParameter("txtPassWord");
            String rePassword = request.getParameter("txtRePassWord");
            if (id.length() < 1) {
                errorDTO.setErrorid("UserID cannot empty");
                check = false;
            }
            if (fullName.length() < 1 || fullName.length() > 20) {
                errorDTO.setErrorname("Full name must more than 1 and less than 10");
                check = false;
            }
            if (!password.equals(rePassword)) {
                errorDTO.setErrorpassword("password and repass is not matches");
                check = false;
            }
            UserDAO dao = new UserDAO();
            boolean exits = dao.checkID(id);
            if (!exits) {
                errorDTO.setErrorid("UserID is already exist");
                check = false;
            }
            if (check) {
                UserDTO dto = new UserDTO(id, fullName, password, roleid);
                dao.create(dto);
                url = SUCCESS;
            } else {
                request.setAttribute("ERROR_USER", errorDTO);
            }

        } catch (Exception e) {
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
