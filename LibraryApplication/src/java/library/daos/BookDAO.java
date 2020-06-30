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
public class BookDAO{

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

    public List<BookDTO> getListBook(String search)throws Exception {
        List<BookDTO> result = new ArrayList<BookDTO>();
        try {
            String sql = "SELECT BookID, Title, Price, Author, Quantity"
                    + "FROM tblBooks WHERE Title=?";
            con = DBUtils.getConnection();
            preStm = con.prepareStatement(sql);
            preStm.setString(1, "%"+search+"%");
            rs = preStm.executeQuery();
            if (rs.next()) {
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
            String sql = "INSERT INTO Books(BookID, Title, Price, Author, Quantity) VALUES(?,?,?,?,?)";
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

    public boolean delete(String bookid) throws Exception {
        boolean check = false;

        try {
            String sql = "DELETE FROM tblBooks WHERE BookID = ?";
            con = DBUtils.getConnection();
            preStm = con.prepareStatement(sql);
            preStm.setString(1, bookid);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean update(BookDTO dto) throws Exception {
        boolean check = false;

        try {
            String sql = "UPDATE tblBooks SET Price = ?, Quantity = ? WHERE BookID = ?";
            con = DBUtils.getConnection();
            preStm = con.prepareStatement(sql);
            preStm.setFloat(1, dto.getPrice());
            preStm.setInt(2, dto.getQuantity());
            preStm.setString(3, dto.getBookcode());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

}
