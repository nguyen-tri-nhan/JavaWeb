/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import library.daos.BookDAO;
import library.daos.OrderDAO;
import library.daos.OrderDetailDAO;
import library.dtos.OrderDTO;
import library.dtos.OrderDetailDTO;

/**
 *
 * @author Lenovo
 */
public class UpdateOrderController extends HttpServlet {

    private static final String SUCCESS = "ShowOrderController";
    private static final String ERROR = "ShowOrderController";

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
            String orderid = request.getParameter("txtOrderId");
            OrderDetailDAO detaildao = new OrderDetailDAO();
            BookDAO bookdao = new BookDAO();
            OrderDAO dao = new OrderDAO();
            OrderDTO dto = new OrderDTO(orderid, null, null, null, true, 2);
            dao.update(dto);
            List<OrderDetailDTO> list = detaildao.getListOrderDetails(orderid);
            if (dto.isReturned()) {
                for (OrderDetailDTO orderDetailDTO : list) {
                    String bookid = orderDetailDTO.getBookid();
                    int quantity = bookdao.getQuantityByID(bookid);
                    int amount = orderDetailDTO.getAmount();
                    bookdao.updateQuantity(bookid, quantity + amount);
                }
                url = SUCCESS;
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
