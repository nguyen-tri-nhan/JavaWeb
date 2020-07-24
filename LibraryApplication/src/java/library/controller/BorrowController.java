/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import library.daos.BookDAO;
import library.daos.OrderDAO;
import library.daos.OrderDetailDAO;
import library.dtos.BookDTO;
import library.dtos.CartDTO;
import library.dtos.OrderDTO;
import library.dtos.OrderDetailDTO;
import library.dtos.UserDTO;

/**
 *
 * @author Lenovo
 */
public class BorrowController extends HttpServlet {

    public static final String DONE = "library.jsp";
    public static final String FAIL = "invalid.html";

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
        HttpSession session = request.getSession();
        String url = FAIL;
        OrderDAO orderdao = new OrderDAO();
        OrderDetailDAO detaildao = new OrderDetailDAO();
        OrderDTO orderdto = null;
        OrderDetailDTO detaildto = null;
        BookDAO bookdao = new BookDAO();
        try {
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            UserDTO user = (UserDTO) session.getAttribute("USER");
            String inputDate = request.getParameter("calendar");
            String[] lastorderid = orderdao.getLastOrderID().split("/");
            String[] lastdetailid = detaildao.getLastID().split("/");
            int maxDetailID = Integer.parseInt(lastdetailid[3]);
            int maxOrderID = Integer.parseInt(lastorderid[3]);
            int newDetailID = maxDetailID + 1;
            int newOrderID = maxOrderID + 1;
            String orderID = null;
            if (newOrderID < 10) {
                orderID = lastorderid[0] + "/" + lastorderid[1] + "/" + lastorderid[2] + "/" + "000" + String.valueOf(newOrderID);
            } else if (newOrderID < 100) {
                orderID = lastorderid[0] + "/" + lastorderid[1] + "/" + lastorderid[2] + "/" + "00" + String.valueOf(newOrderID);
            } else if (newOrderID < 1000) {
                orderID = lastorderid[0] + "/" + lastorderid[1] + "/" + lastorderid[2] + "/" + "0" + String.valueOf(newOrderID);
            }
            long millis = System.currentTimeMillis();
            Date currentday = new Date(millis);
            Date returnDate = null;
            if (inputDate != null && !inputDate.equals("")) {
                java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(inputDate);
                returnDate = new java.sql.Date(date.getTime());
            } else {
                long nextMonth = millis + 2592000000L;
                returnDate = new Date(nextMonth);
            }

            String uid = user.getId();
            for (BookDTO dto : cart.getCart().values()) {
                String bookcode = dto.getBookcode();
                int dbquantity = bookdao.getQuantityByID(bookcode);
                int quantity = dto.getQuantity();
                if (dbquantity >= quantity) {
                    String newIndex = null;
                    if (newDetailID < 10) {
                        newIndex = "000" + String.valueOf(newDetailID);
                    } else if (newDetailID < 100) {
                        newIndex = "00" + String.valueOf(newDetailID);
                    } else if (newDetailID < 1000) {
                        newIndex = "0" + String.valueOf(newDetailID);
                    }
                    String detailID = lastdetailid[0] + "/" + lastdetailid[1] + "/" + lastdetailid[2] + "/" + newIndex;
                    detaildto = new OrderDetailDTO(detailID, orderID, dto.getBookcode(), dto.getQuantity());
                    detaildao.insert(detaildto);
                    bookdao.updateQuantity(bookcode, dbquantity - quantity);
                    newDetailID++;
                } else {
                    throw new Exception();
                }
            }
            orderdto = new OrderDTO(orderID, uid, currentday, returnDate, false, 0);
            orderdao.insert(orderdto);
            session.setAttribute("CART", null);
            url = DONE;
        } catch (Exception e) {
            session.setAttribute("CART", null);
            url = DONE;
            e.printStackTrace();
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
