/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import library.dtos.OrderDTO;
import library.utils.DBUtils;

/**
 *
 * @author Lenovo
 */
public class OrderDAO {

    private Connection conn = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;

    private void closeConnection(){
        try {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
        }

    }

    public void insert(OrderDTO dto) throws Exception {
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblOrder(OrderID,OrderDate,UserID,ReturnDate)"
                        + " VALUES(?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, dto.getOrderid());
                stm.setDate(2, dto.getOrderdate());
                stm.setString(3, dto.getUserid());
                stm.setDate(4, dto.getReturndate());
                stm.executeUpdate();
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
    }


    public void update(OrderDTO dto) throws SQLException, Exception {
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblOrder SET IsReturned = ?, IsRequired = ? "
                        + " WHERE OrderID = ?";
                stm = conn.prepareStatement(sql);
                stm.setBoolean(1, dto.isReturned());
                stm.setInt(2, 2);
                stm.setString(3, dto.getOrderid());
                stm.executeUpdate();
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }

    }

    public List<OrderDTO> getListOrder(String search) throws Exception {
        List<OrderDTO> result = new ArrayList<OrderDTO>();
        try {
            String sql = "SELECT OrderID, OrderDate, UserID, ReturnDate, IsReturned, IsRequired FROM tblOrder "
                    + "WHERE UserID like ?";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, "%" + search + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                String orderid = rs.getString(1);
                Date orderdate = rs.getDate(2);
                String userid = rs.getString(3);
                Date returndate = rs.getDate(4);
                boolean returned = rs.getBoolean(5);
                int required = rs.getInt(6);
                result.add(new OrderDTO(orderid, userid, orderdate, returndate, returned, required));
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public String getLastOrderID() throws Exception {
        String result = null;
        try {
            String sql = "SELECT MAX(OrderID) FROM tblOrder";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            if (rs.next()) {
                result = rs.getString(1);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public void updateRequired(String id){
        try {
            String sql = "UPDATE tblOrder SET IsRequired = ?"
                    + " WHERE OrderID = ? ";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            int userRequired = 1;
            stm.setInt(1, userRequired);
            stm.setString(2, id);
            stm.executeUpdate();
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
    }
}
