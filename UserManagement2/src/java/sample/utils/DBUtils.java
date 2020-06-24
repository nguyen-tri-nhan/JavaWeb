/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author nguyentrinhan2000
 */
public class DBUtils {
//    public static Connection getConnection() throws ClassNotFoundException, SQLException{
//        Connection conn = null;
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=UserManagement;";
//        conn = DriverManager.getConnection(url, "sa", "123456789");
//        return conn;
//    }
    public static Connection getConnection() throws ClassCastException, SQLException, NamingException {
        Connection conn = null;
        Context context = new InitialContext();
        Context end = (Context) context.lookup("java:comp/env");
        DataSource ds = (DataSource) end.lookup("DBConnection");
        conn = ds.getConnection();
        return conn;
    }
}
