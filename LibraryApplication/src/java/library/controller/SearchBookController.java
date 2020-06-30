/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import library.daos.BookDAO;
import library.dtos.BookDTO;

/**
 *
 * @author Lenovo
 */
public class SearchBookController extends HttpServlet {

    private static final String SUCCESS = "bookmanagement.jsp";
    private static final String ERROR = "invalid.html";

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
            String search = request.getParameter("txtSearchBook");
            BookDAO dao = new BookDAO();
            List<BookDTO> list = dao.getListBook(search);
            if (!list.isEmpty()) {
                url = SUCCESS;
                request.setAttribute("LIST_BOOK_MANAGEMENT", list);
            }
        } catch (Exception e) {
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }
}
