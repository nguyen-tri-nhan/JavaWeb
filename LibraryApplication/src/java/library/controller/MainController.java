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

/**
 *
 * @author nguyentrinhan2000
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "invalid.html";
    private static final String LOGIN = "LoginController";
    private static final String SEARCH_USER = "SearchUserController";
    private static final String LOGOUT = "LogoutController";
    private static final String BAN_USER = "BanUserController";
    private static final String CREATE_STUDENT = "CreateStudentController";
    private static final String UPDATE_USER = "UpdateUserController";
    private static final String INSTANT_CREATE = "CreateInstantController";
    private static final String SEARCH_BOOK = "SearchBookController";
    private static final String CREATE_BOOK = "CreateBookController";
    private static final String UPDATE_BOOK = "UpdateBookController";
    private static final String SHOW_ORDER = "ShowOrderController";
    private static final String UPDATE_ORDER = "UpdateOrderController";
    private static final String VIEW_ORDER_DETAIL = "OrderDetailViewController";
    private static final String FILTER_BOOK = "FilterBookController";
    private static final String ADD_TO_CART = "AddToCartController";
    private static final String VIEW_CART = "cart.jsp";
    private static final String CANCEL_CART = "CancelCartController";
    private static final String BORROW = "BorrowController";
    private static final String DETAIL = "UserViewDetailsController";
    private static final String ACTIVE = "ActiveBookController";
    private static final String UPDATE_CART = "UpdateCartController";
    private static final String REQUIRE = "RequireController";
    private static final String REMOVE = "RemoveController";

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
            } else if (action.equals("Search User")) {
                url = SEARCH_USER;
            } else if (action.equals("Logout")) {
                url = LOGOUT;
            } else if (action.equals("Ban User") || action.equals("Unban User")) {
                url = BAN_USER;
            } else if (action.equals("Register")) {
                url = CREATE_STUDENT;
            } else if (action.equals("Update User")) {
                url = UPDATE_USER;
            } else if (action.equals("Instant Create")) {
                url = INSTANT_CREATE;
            } else if (action.equals("Search Book")) {
                url = SEARCH_BOOK;
            } else if (action.equals("Create Book")) {
                url = CREATE_BOOK;
            } else if (action.equals("Update Book")) {
                url = UPDATE_BOOK;
            } else if (action.equals("Show Order")) {
                url = SHOW_ORDER;
            } else if (action.equals("Accept")) {
                url = UPDATE_ORDER;
            } else if (action.equals("View Details")) {
                url = VIEW_ORDER_DETAIL;
            } else if (action.equals("Filter")) {
                url = FILTER_BOOK;
            } else if (action.equals("Add To Cart")) {
                url = ADD_TO_CART;
            } else if (action.equals("View Cart")) {
                url = VIEW_CART;
            } else if (action.equals("Cancel")) {
                url = CANCEL_CART;
            } else if (action.equals("Borrow")) {
                url = BORROW;
            } else if (action.equals("View Orderdetails")) {
                url = DETAIL;
            } else if (action.equals("Active") || action.equals("Deactive")) {
                url = ACTIVE;
            } else if (action.equals("Update Element")) {
                url = UPDATE_CART;
            } else if (action.equals("Require")) {
                url = REQUIRE;
            } else if (action.equals("Remove")) {
                url = REMOVE;
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
