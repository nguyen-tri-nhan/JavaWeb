/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.beans;

import java.sql.SQLException;
import sample.daos.UserDAO;

/**
 *
 * @author nguyentrinhan2000
 */
public class UserBean {
    private String userID, password;

    public UserBean() {
    }

    public UserBean(String userID, String password) {
        this.userID = userID;
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean checkLogin() throws SQLException{
        UserDAO dao = new UserDAO();
        boolean check = dao.checkLogin(userID, password);
        return check;
    }
}
