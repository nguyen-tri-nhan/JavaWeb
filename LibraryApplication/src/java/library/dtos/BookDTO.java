package library.dtos;

public class BookDTO {

    private String bookcode, title, author, publisher, language, genre;
    private float price;
    private int quantity;
    private boolean active;

    public BookDTO() {
    }

    public BookDTO(String bookcode, String title, String author, String publisher, String language, String genre, float price, int quantity, boolean active) {
        this.bookcode = bookcode;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.language = language;
        this.genre = genre;
        this.price = price;
        this.quantity = quantity;
        this.active = active;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    

    

}
