/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import library.daos.BookDAO;
import library.dtos.BookDTO;
import library.dtos.ErrorBookDTO;

/**
 *
 * @author Lenovo
 */
public class CreateBookController extends HttpServlet {
    private static final String SUCCESS = "SearchBookController";
    private static final String ERROR = "bookmanagement.jsp";
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
            ErrorBookDTO errorDTO = new ErrorBookDTO("", "", "", "", "");
            boolean check = true;
            String bookid = request.getParameter("txtNewBookID");
            String title = request.getParameter("txtNewTitle");
            float price = Float.parseFloat(request.getParameter("txtNewPrice"));
            String author = request.getParameter("txtNewAuthor");
            String publisher = request.getParameter("txtNewPublisher");
            String language = request.getParameter("txtNewLanguage");
            String genre = request.getParameter("txtNewGenre");
            int quantity = Integer.parseInt(request.getParameter("txtNewQuantity"));
            BookDAO dao = new BookDAO();
            boolean exits = dao.checkExits(bookid);
            if (bookid.length() < 1){
                errorDTO.setErrorbookcode("Book id cannot empty");
                check = false;
            }
            if (title.length() < 1){
                errorDTO.setErrortitle("Book name cannot empty");
                check = false;
            }
            if (price < 0){
                errorDTO.setErrorprice("Price cannot minus number");
                check = false;
            }
            if (author.length() < 1){
                errorDTO.setErrorauthor("Book must have at least an author");
                check = false;
            }
            if (language.length() < 1){
                errorDTO.setErrorauthor("Book must have a language");
                check = false;
            }
            if (genre.length() < 1){
               genre = "N/A";
            }
            if (publisher.length() < 1){
                errorDTO.setErrorauthor("Book must have a publisher");
            }
            if (quantity < 0){
                errorDTO.setErrorquantity("Book does not exists");
                check = false;
            }
            if (!exits){
                errorDTO.setErrorbookcode("BookID is already exists");
                check = false;
            }
            if (check) {
                BookDTO dto = new BookDTO(bookid, title, author, publisher, language, genre, price, quantity, true);
                dao.insert(dto);
                url = SUCCESS;
            } else {
                request.setAttribute("ERROR_BOOK", errorDTO);
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
