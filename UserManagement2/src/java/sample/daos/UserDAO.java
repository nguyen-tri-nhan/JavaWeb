/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.dtos.UserDTO;
import sample.utils.DBUtils;

/**
 *
 * @author nguyentrinhan2000
 */
public class UserDAO {

    public String checkLogin(String userID, String password) throws SQLException {
        String result = "";
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT fullName FROM tbUser "
                        + "WHERE userID = " + "'" + userID + "'" + " AND password = " + "'" + password + "'";
                //String sql = "SELECT userID FROM tbUser WHERE userID=?" + " AND password = ?";
                stm = conn.prepareStatement(sql);
//                stm.setString(1, userID);
//                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = rs.getNString("fullName");
                }
            }
        } catch (Exception e) {
        } finally {
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
        return result;
    }

    public String isAdmin(String userID, String password) throws SQLException {
        String result = "";
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT roleID FROM tbUser "
                        + "WHERE userID = " + "'" + userID + "'" + " AND password = " + "'" + password + "'";
                //String sql = "SELECT userID FROM tbUser WHERE userID=?" + " AND password = ?";
                stm = conn.prepareStatement(sql);
//                stm.setString(1, userID);
//                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = rs.getNString("roleID");
                }
            }
        } catch (Exception e) {
        } finally {
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
        return result;
    }
    
    public List<UserDTO> getListUser(String search) throws SQLException {
        List<UserDTO> result = new ArrayList<UserDTO>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT userID, fullName, roleID FROM tbUser"
                        + " WHERE fullName like ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String fullName = rs.getString("fullName");
                    String password = "***";
                    String roleID = rs.getString("roleID");
                    result.add(new UserDTO(userID, fullName, password, roleID));
                }
            }
        } catch (Exception e) {
        } finally {
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
        return result;
    }
    public void delete(String userID) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "DELETE tbUser"
                        + " WHERE userID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.executeUpdate();
                
            }
        } catch (Exception e) {
        } finally {
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
    }
    public boolean checkID(String userID) throws SQLException {
        boolean result = true;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT fullName FROM tbUser "
                        + "WHERE userID = " + "'" + userID + "'";
                //String sql = "SELECT userID FROM tbUser WHERE userID=?" + " AND password = ?";
                stm = conn.prepareStatement(sql);
//                stm.setString(1, userID);
//                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = false;
                }
            }
        } catch (Exception e) {
        } finally {
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
        return result;
    }
    public void create(UserDTO dto) throws SQLException {
        boolean result = true;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tbUser(userID, password, fullName, roleID)"
                        + " VALUES (?,?,?,?)";
                //String sql = "SELECT userID FROM tbUser WHERE userID=?" + " AND password = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, dto.getUserID());
                stm.setString(2, dto.getPassword());
                stm.setString(3, dto.getFullName());
                stm.setString(4, dto.getRoleID());
                stm.executeUpdate();
            }
        } catch (Exception e) {
        } finally {
            
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        
    }
    public void update(UserDTO dto) throws SQLException {
        boolean result = true;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tbUser SET fullName = ?, roleID = ?"
                        + " WHERE UserID = ?";
                //String sql = "SELECT userID FROM tbUser WHERE userID=?" + " AND password = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, dto.getFullName());
                stm.setString(2, dto.getRoleID());
                stm.setString(3, dto.getUserID());
                stm.executeUpdate();
            }
        } catch (Exception e) {
        } finally {
            
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        
    }
}
