/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.dtos;

/**
 *
 * @author Lenovo
 */
public class OrderDetailViewDTO {
    private String id, bookname;
    int amount;
    float price;

    public OrderDetailViewDTO() {
    }

    public OrderDetailViewDTO(String id, String bookname, int amount, float price) {
        this.id = id;
        this.bookname = bookname;
        this.amount = amount;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
