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

/**
 *
 * @author nguyentrinhan2000
 */
public class MainController extends HttpServlet {
    private static final String ERROR = "invalid.jsp";
    private static final String LOGIN = "LoginController";
    private static final String SEARCH = "SearchController";
    private static final String LOGOUT = "LogoutController";
    private static final String DELETE = "DeleteController";
    private static final String CREATE = "CreateController";
    private static final String UPDATE = "UpdateController";
    private static final String UPDATE_PAGE = "update.jsp";
    private static final String ADD = "AddController";
    private static final String VIEW = "viewcart.jsp";
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
            String action = request.getParameter("btnAction");
            if (action.equals("Login")) {
                url = LOGIN;
            } else if (action.equals("Search")){
                url = SEARCH;
            } else if (action.equals("Logout")){
                url = LOGOUT;
            } else if (action.equals("Delete")){
                url = DELETE;
            } else if (action.equals("Create")){
                url = CREATE;
            } else if (action.equals("Update")){
                url = UPDATE;
            } else if (action.equals("Updatepage")){
                url = UPDATE_PAGE;
            } else if (action.equals("Add")){
                url = ADD;
            } else if (action.equals("View")){
                url = VIEW;
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
