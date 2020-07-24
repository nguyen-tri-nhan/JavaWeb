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
public class FilterBookController extends HttpServlet {

    public static final String DONE = "library.jsp";

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
        String url = DONE;
        try {
            String filter = request.getParameter("cmbFilter");
            String search = request.getParameter("txtSearchBook");
            float price;
            BookDAO dao = new BookDAO();
            List<BookDTO> list = null;
            switch (filter) {
                case "Name":
                    list = dao.getListBook(search);
                    if (!list.isEmpty()) {
                        request.setAttribute("LIST_BOOK_VIEW", list);
                    }
                    break;
                case "Price":
                    if (search.isEmpty()) {
                        price = Float.MAX_VALUE;
                    } else {
                        price = Float.parseFloat(search);
                    }
                    list = dao.listBookByPrice(price, "ASC");
                    if (!list.isEmpty()) {
                        request.setAttribute("LIST_BOOK_VIEW", list);
                    }
                    break;
                case "Author":
                    list = dao.listBookByAuthor(search);
                    if (!list.isEmpty()) {
                        request.setAttribute("LIST_BOOK_VIEW", list);
                    }
                    break;
                case "Language":
                    list = dao.listBookByLanguage(search);
                    if (!list.isEmpty()) {
                        request.setAttribute("LIST_BOOK_VIEW", list);
                    }
                    break;
                case "Publisher":
                    list = dao.listBookByPublisher(search);
                    if (!list.isEmpty()) {
                        request.setAttribute("LIST_BOOK_VIEW", list);
                    }
                    break;
                case "Genre":
                    list = dao.listBookByGenre(search);
                    if (!list.isEmpty()) {
                        request.setAttribute("LIST_BOOK_VIEW", list);
                    }
                    break;
                default:
                    break;
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
