/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import library.dtos.OrderDetailDTO;
import library.dtos.OrderDetailViewDTO;
import library.utils.DBUtils;

/**
 *
 * @author Lenovo
 */
public class OrderDetailDAO {
    
    private Connection conn = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
    
    public List<OrderDetailDTO> getListOrderDetails(String search) throws Exception {
        List<OrderDetailDTO> result = new ArrayList<OrderDetailDTO>();
        try {
            String sql = "SELECT ID, OrderID, BookID, Amount FROM OrderDetail "
                    + "WHERE OrderID = ?";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, search);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String orderid = rs.getString(2);
                String bookid = rs.getString(3);
                int amount = rs.getInt(4);
                OrderDetailDTO dto = new OrderDetailDTO(id, orderid, bookid, amount);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    public List<OrderDetailViewDTO> getListOrderDetailView(String search) throws Exception {
        List<OrderDetailViewDTO> result = new ArrayList<OrderDetailViewDTO>();
        try {
            String sql = "SELECT dt.ID, bk.Title, dt.Amount, bk.Price FROM OrderDetail dt, tblBooks bk "
                    + "WHERE dt.OrderID = ? AND dt.BookID = bk.BookID";
            //SELECT dt.ID, bk.Title, dt.Amount, bk.Price FROM OrderDetail dt, tblBooks bk WHERE OrderID = 'SU/2020/OD0001' AND dt.BookID = bk.BookID
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, search);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String bookname = rs.getString(2);
                int amount = rs.getInt(3);
                float price = rs.getFloat(4);
                OrderDetailViewDTO dto = new OrderDetailViewDTO(id, bookname, amount, price);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    public String getLastID() throws Exception{
        //SELECT MAX(ID) FROM OrderDetail
        String result = null;
        try {
            String sql = "SELECT MAX(ID) FROM OrderDetail";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            if (rs.next()){
                result = rs.getString(1);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public void insert(OrderDetailDTO dto) throws Exception{
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO OrderDetail(ID,BookID,Amount,OrderID)"
                        + " VALUES(?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, dto.getId());
                stm.setString(2, dto.getBookid());
                stm.setInt(3, dto.getAmount());
                stm.setString(4, dto.getOrderid());
                stm.executeUpdate();
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
    }
}
