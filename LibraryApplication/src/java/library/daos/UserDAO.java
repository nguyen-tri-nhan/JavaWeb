/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import library.dtos.UserDTO;
import library.utils.DBUtils;

/**
 *
 * @author nguyentrinhan2000
 */
public class UserDAO {

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
    public UserDTO checkLogin(String ID, String password) throws SQLException, Exception {
        UserDTO result = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                
                //String sql = "SELECT ID ,FullName, RoleID FROM tblUsers WHERE ID = ? AND Password = ?";
                String sql = "SELECT U.ID, U.FullName, R.RoleName FROM tblUsers U, tblRoles R WHERE U.RoleID = R.RoleID AND ID = ? AND Password = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, ID);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = new UserDTO(rs.getString("ID"), rs.getString("FullName"), "***", rs.getString("RoleName"));
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return result;
    }



    public List<UserDTO> getListUser(String search) throws SQLException, Exception {
        List<UserDTO> result = new ArrayList<UserDTO>();
        
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT U.ID, U.FullName, R.RoleName FROM tblUsers U, tblRoles R WHERE U.FullName like ? AND U.RoleID = R.RoleID";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("ID");
                    String fullName = rs.getString("FullName");
                    String password = "***";
                    String role = rs.getString("RoleName");
                    result.add(new UserDTO(userID, fullName, password, role));
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return result;
    }

    public void delete(String userID) throws SQLException, Exception {
        
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "DELETE tblUsers"
                        + " WHERE ID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.executeUpdate();

            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
    }

    public boolean checkID(String userID) throws SQLException, Exception {
        boolean result = true;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT ID FROM tblUsers WHERE ID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = false;
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return result;
    }

    public void create(UserDTO dto) throws SQLException, Exception {
        boolean result = true;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblUsers(ID, Password, FullName, RoleID)"
                        + " VALUES (?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, dto.getId());
                stm.setString(2, dto.getPassword());
                stm.setString(3, dto.getFullName());
                stm.setInt(4, Integer.parseInt(dto.getRole()));
                stm.executeUpdate();
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }

    }

    public void update(UserDTO dto) throws SQLException, Exception {
        boolean result = true;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblUsers SET FullName = ?"
                        + " WHERE ID = ?";
                //String sql = "SELECT userID FROM tbUser WHERE userID=?" + " AND password = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, dto.getFullName());
                stm.setString(2, dto.getId());
                stm.executeUpdate();
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }

    }
}
