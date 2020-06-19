/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.dtos.UserDTO;

/**
 *
 * @author nguyentrinhan2000
 */
public class SearchResult extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchResult</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Welcome "+ session.getAttribute("fullName") + "</h1>");
            out.println("<h1>Servlet SearchResult at " + request.getContextPath() + "</h1>");
            out.println("<table border=" + 1 + ">");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>NO</th>");
            out.println("<th>USERID</th>");
            out.println("<th>FULLNAME</th>");
            out.println("<th>password</th>");
            out.println("<th>roleID</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            List<UserDTO> list = (List<UserDTO>) request.getAttribute("LIST_USER");
            int count = 0;
            for (UserDTO dto : list) {
                out.println("<tr>");
                
                out.println("<td>"+ count+1 +"</td>");
                out.println("<td>" + dto.getUserID() + "</td>");
                out.println("<td>" + dto.getFullName() + "</td>");
                out.println("<td>" + dto.getPassword() + "</td>");
                out.println("<td>" + dto.getRoleID() + "</td>");
                out.println("</tr>");
                count++;
            }
//                out.println("<tr>");
//                    out.println("<td></td>");
//                    out.println("<td></td>");
//                    out.println("<td></td>");
//                    out.println("<td></td>");
//                    out.println("<td></td>");
//                out.println("</tr>");
//            out.println("</tbody>");
//        out.println("</table>");
//            out.println("</body>");
//            out.println("</html>");
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
