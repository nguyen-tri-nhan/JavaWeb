/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nguyentrinhan2000
 */
public class DBUtils {
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=BookManagement;";
        conn = DriverManager.getConnection(url, "new", "123456789");
        return conn;
    }
}
