package library.dtos;

public class BookDTO {

    private String bookcode, title, author;
    private float price;
    private int quantity;

    public BookDTO() {
    }

    public BookDTO(String bookcode, String title, String author, float price, int quantity) {
        this.bookcode = bookcode;
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    public String getBookcode() {
        return bookcode;
    }

    public void setBookcode(String bookcode) {
        this.bookcode = bookcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
