package library.daos;

import java.io.Serializable;
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
public class BookDAO implements Serializable {

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

        BookDTO dto = null;

        try {
            String sql = "SELECT bookName FROM Books";
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

    public BookDTO findByBookName(String bookName) throws Exception {
        BookDTO dto = null;

        try {
            String sql = "SELECT bookCode, author, publisher, publishYear, forRent FROM Books WHERE bookName = ?";
            con = DBUtils.getConnection();
            preStm = con.prepareStatement(sql);
            preStm.setString(1, bookName);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String bookCode = rs.getString("bookCode");
                String author = rs.getString("Author");
                String publisher = rs.getString("Publisher");
                int publishYear = rs.getInt("publishYear");
                boolean forRent = rs.getBoolean("forRent");
                dto = new BookDTO(bookCode, bookName, author, publisher, publishYear, forRent);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean insert(BookDTO dto) throws Exception {
        boolean check = false;

        try {
            String sql = "INSERT INTO Books(bookCode, bookName, author, publisher, publishYear, forRent) VALUES(?,?,?,?,?,?)";
            con = DBUtils.getConnection();
            preStm = con.prepareStatement(sql);
            preStm.setString(1, dto.getBookCode());
            preStm.setString(2, dto.getBookName());
            preStm.setString(3, dto.getAuthor());
            preStm.setString(4, dto.getPublisher());
            preStm.setInt(5, dto.getPublishYear());
            preStm.setBoolean(6, dto.isForRent());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean delete(String bookCode) throws Exception {
        boolean check = false;

        try {
            String sql = "DELETE FROM Books WHERE bookCode = ?";
            con = DBUtils.getConnection();
            preStm = con.prepareStatement(sql);
            preStm.setString(1, bookCode);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean update(BookDTO dto) throws Exception {
        boolean check = false;

        try {
            String sql = "UPDATE Books SET author = ?, publisher = ?, publishYear = ?, forRent = ? WHERE bookCode = ?";
            con = DBUtils.getConnection();
            preStm = con.prepareStatement(sql);
            preStm.setString(1, dto.getAuthor());
            preStm.setString(2, dto.getPublisher());
            preStm.setInt(3, dto.getPublishYear());
            preStm.setBoolean(4, dto.isForRent());
            preStm.setString(5, dto.getBookCode());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

}
