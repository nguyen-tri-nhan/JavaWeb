package library.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public BookDTO getBookByID(String id) throws Exception {
        BookDTO result = null;
        try {
            String sql = "SELECT BookID, Title, Price, Author, Publisher, Language, Genre, IsActive FROM tblBooks "
                    + "WHERE BookID = ?";
            con = DBUtils.getConnection();
            preStm = con.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String title = rs.getNString("Title");
                float price = rs.getFloat("Price");
                String author = rs.getNString("Author");
                String publisher = rs.getNString("Publisher");
                String language = rs.getString("Language");
                String genre = rs.getString("Genre");
                boolean active = rs.getBoolean("IsActive");
                result = new BookDTO(id, title, author, publisher, language, genre, price, 1, active);
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return result;
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

    public List<BookDTO> getListBook(String search) throws Exception {
        List<BookDTO> result = new ArrayList<BookDTO>();
        try {
            String sql = "SELECT BookID, Title, Price, Author, Publisher, Language, Genre, Quantity, IsActive FROM tblBooks "
                    + "WHERE Title like ?";
            con = DBUtils.getConnection();
            preStm = con.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                String bookid = rs.getString("BookID");
                String title = rs.getString("Title");
                float price = rs.getFloat("Price");
                String author = rs.getNString("Author");
                String publisher = rs.getNString("Publisher");
                String language = rs.getString("Language");
                String genre = rs.getString("Genre");
                int quantity = rs.getInt("Quantity");
                boolean active = rs.getBoolean("IsActive");
                result.add(new BookDTO(bookid, title, author, publisher, language, genre, price, quantity, active));
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<BookDTO> getListBookView() throws Exception {
        List<BookDTO> result = new ArrayList<BookDTO>();
        try {
            String sql = "SELECT BookID, Title, Price, Author, Publisher, Language, Genre, Quantity, IsActive FROM tblBooks "
                    + "WHERE Quantity > 0 "
                    + "AND IsActive = '1'";
            con = DBUtils.getConnection();
            preStm = con.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                String bookid = rs.getString("BookID");
                String title = rs.getString("Title");
                float price = rs.getFloat("Price");
                String author = rs.getNString("Author");
                String publisher = rs.getNString("Publisher");
                String language = rs.getString("Language");
                String genre = rs.getString("Genre");
                int quantity = rs.getInt("Quantity");
                boolean active = rs.getBoolean("IsActive");
                result.add(new BookDTO(bookid, title, author, publisher, language, genre, price, quantity, active));
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<BookDTO> listBookByPrice(float search, String sub) {
        List<BookDTO> result = new ArrayList<BookDTO>();
        try {
            String sql = "SELECT BookID, Title, Price, Author, Publisher, Language, Genre, Quantity FROM tblBooks "
                    + " WHERE Price <= ? AND Quantity > 0 AND IsActive = 1 "
                    + " ORDER BY Price";
            //SELECT BookID, Title, Price, Author, Publisher, Language, Genre, Quantity FROM tblBooks WHERE Price > 100000.0 or Price = 100000.0 ORDER BY Price DESC
            con = DBUtils.getConnection();
            preStm = con.prepareStatement(sql);
            preStm.setFloat(1, search);
            rs = preStm.executeQuery();
            while (rs.next()) {
                String bookid = rs.getString("BookID");
                String title = rs.getString("Title");
                float price = rs.getFloat("Price");
                String author = rs.getNString("Author");
                String publisher = rs.getNString("Publisher");
                String language = rs.getString("Language");
                String genre = rs.getString("Genre");
                int quantity = rs.getInt("Quantity");
                result.add(new BookDTO(bookid, title, author, publisher, language, genre, price, quantity, true));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public List<BookDTO> listBookByAuthor(String search) throws Exception {
        List<BookDTO> result = new ArrayList<BookDTO>();
        try {
            String sql = "SELECT BookID, Title, Price, Author, Publisher, Language, Genre, Quantity FROM tblBooks "
                    + "WHERE Author like ? AND Quantity > 0 AND IsActive = 1 "
                    + "ORDER BY Author";
            con = DBUtils.getConnection();
            preStm = con.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                String bookid = rs.getString("BookID");
                String title = rs.getString("Title");
                float price = rs.getFloat("Price");
                String author = rs.getNString("Author");
                String publisher = rs.getNString("Publisher");
                String language = rs.getString("Language");
                String genre = rs.getString("Genre");
                int quantity = rs.getInt("Quantity");
                result.add(new BookDTO(bookid, title, author, publisher, language, genre, price, quantity, true));
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<BookDTO> listBookByLanguage(String search) throws Exception {
        List<BookDTO> result = new ArrayList<BookDTO>();
        try {
            String sql = "SELECT BookID, Title, Price, Author, Publisher, Language, Genre, Quantity FROM tblBooks "
                    + "WHERE Language like ? AND Quantity > 0 AND IsActive = 1 "
                    + "ORDER BY Language";
            con = DBUtils.getConnection();
            preStm = con.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                String bookid = rs.getString("BookID");
                String title = rs.getString("Title");
                float price = rs.getFloat("Price");
                String author = rs.getNString("Author");
                String publisher = rs.getNString("Publisher");
                String language = rs.getString("Language");
                String genre = rs.getString("Genre");
                int quantity = rs.getInt("Quantity");
                result.add(new BookDTO(bookid, title, author, publisher, language, genre, price, quantity, true));
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<BookDTO> listBookByPublisher(String search) throws Exception {
        List<BookDTO> result = new ArrayList<BookDTO>();
        try {
            String sql = "SELECT BookID, Title, Price, Author, Publisher, Language, Genre, Quantity FROM tblBooks "
                    + "WHERE Publisher like ? AND Quantity > 0 AND IsActive = 1 "
                    + "ORDER BY Publisher";
            con = DBUtils.getConnection();
            preStm = con.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                String bookid = rs.getString("BookID");
                String title = rs.getString("Title");
                float price = rs.getFloat("Price");
                String author = rs.getNString("Author");
                String publisher = rs.getNString("Publisher");
                String language = rs.getString("Language");
                String genre = rs.getString("Genre");
                int quantity = rs.getInt("Quantity");
                result.add(new BookDTO(bookid, title, author, publisher, language, genre, price, quantity, true));
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<BookDTO> listBookByGenre(String search) throws Exception {
        List<BookDTO> result = new ArrayList<BookDTO>();
        try {
            String sql = "SELECT BookID, Title, Price, Author, Publisher, Language, Genre, Quantity FROM tblBooks "
                    + "WHERE Genre like ? AND Quantity > 0 AND IsActive = 1 "
                    + "ORDER BY Genre";
            con = DBUtils.getConnection();
            preStm = con.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                String bookid = rs.getString("BookID");
                String title = rs.getString("Title");
                float price = rs.getFloat("Price");
                String author = rs.getNString("Author");
                String publisher = rs.getNString("Publisher");
                String language = rs.getString("Language");
                String genre = rs.getString("Genre");
                int quantity = rs.getInt("Quantity");
                result.add(new BookDTO(bookid, title, author, publisher, language, genre, price, quantity, true));
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean insert(BookDTO dto) throws Exception {
        boolean check = false;

        try {
            String sql = "INSERT INTO tblBooks(BookID, Title, Price, Author, Publisher, Language, Genre, Quantity, IsActive) VALUES(?,?,?,?,?,?,?,?,1)";
            con = DBUtils.getConnection();
            preStm = con.prepareStatement(sql);
            preStm.setString(1, dto.getBookcode());
            preStm.setString(2, dto.getTitle());
            preStm.setFloat(3, dto.getPrice());
            preStm.setString(4, dto.getAuthor());
            preStm.setString(5, dto.getPublisher());
            preStm.setString(6, dto.getLanguage());
            preStm.setString(7, dto.getGenre());
            preStm.setInt(8, dto.getQuantity());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
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

    public void updateStatus(String id, boolean active) throws Exception {
        try {
            String sql = "UPDATE tblBooks SET IsActive = ? "
                    + "WHERE BookID = ?";
            con = DBUtils.getConnection();
            preStm = con.prepareStatement(sql);
            preStm.setBoolean(1, active);
            preStm.setString(2, id);
            preStm.executeUpdate();
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
    }
    
    public void updateQuantity(String id, int quantityminus) throws Exception {
        try {
            String sql = "UPDATE tblBooks SET Quantity = ? "
                    + "WHERE BookID = ?";
            con = DBUtils.getConnection();
            preStm = con.prepareStatement(sql);
            preStm.setInt(1, quantityminus);
            preStm.setString(2, id);
            preStm.executeUpdate();
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
    }

    public int getQuantityByID(String id) throws Exception {
        int result = -1;
        try {
            String sql = "SELECT Quantity FROM tblBooks "
                    + "WHERE BookID = ?";
            //SELECT Quantity FROM tblBooks WHERE BookID = 
            con = DBUtils.getConnection();
            preStm = con.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

}
