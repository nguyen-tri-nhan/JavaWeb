package library.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import library.utils.DBUtils;
import library.dtos.BookDTO;

/**
 *
 * @author nguyentrinhan.dev
 */
public class BookDAO {

    private Connection con = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public List<String> loadAllBookName() throws Exception {
        List<String> list = null;

        try {
            String sql = "SELECT Title FROM tblBooks";
            con = DBUtils.getConnection();
            preStm = con.prepareStatement(sql);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String bookName = rs.getString("bookName");
                list.add(bookName);
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean checkExits(String bookid) throws Exception {
        boolean result = true;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT Title FROM tblBooks WHERE BookID = ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, bookid);
                rs = preStm.executeQuery();
                if (rs.next()){
                    result = false;
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<BookDTO> getListBook(String search) throws Exception {
        List<BookDTO> result = new ArrayList<BookDTO>();
        try {
            String sql = "SELECT BookID, Title, Author, Price, Quantity FROM tblBooks "
                    + "WHERE Title like ?";
            con = DBUtils.getConnection();
            preStm = con.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                String bookid = rs.getString("BookID");
                String title = rs.getString("Title");
                float price = rs.getFloat("Price");
                String author = rs.getString("Author");
                int quantity = rs.getInt("Quantity");
                result.add(new BookDTO(bookid, title, author, price, quantity));
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean insert(BookDTO dto) throws Exception {
        boolean check = false;

        try {
            String sql = "INSERT INTO tblBooks(BookID, Title, Price, Author, Quantity) VALUES(?,?,?,?,?)";
            con = DBUtils.getConnection();
            preStm = con.prepareStatement(sql);
            preStm.setString(1, dto.getBookcode());
            preStm.setString(2, dto.getTitle());
            preStm.setFloat(3, dto.getPrice());
            preStm.setString(4, dto.getAuthor());
            preStm.setInt(5, dto.getQuantity());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public void delete(String bookid) throws Exception {

        try {
            String sql = "DELETE FROM tblBooks WHERE BookID = ?";
            con = DBUtils.getConnection();
            preStm = con.prepareStatement(sql);
            preStm.setString(1, bookid);
            preStm.executeUpdate();
        } finally {
            closeConnection();
        }
    }

    public void update(BookDTO dto) throws Exception {

        try {
            String sql = "UPDATE tblBooks SET Price = ?, Quantity = ?"
                    + " WHERE BookID = ?";
            con = DBUtils.getConnection();
            preStm = con.prepareStatement(sql);
            preStm.setFloat(1, dto.getPrice());
            preStm.setInt(2, dto.getQuantity());
            preStm.setString(3, dto.getBookcode());
            preStm.executeUpdate();
        } finally {
            closeConnection();
        }
    }

}
