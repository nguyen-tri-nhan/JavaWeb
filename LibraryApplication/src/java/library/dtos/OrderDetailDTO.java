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
public class OrderDetailDTO {

    String id, orderid, bookid;
    int amount;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(String id, String orderid, String bookid, int amount) {
        this.id = id;
        this.orderid = orderid;
        this.bookid = bookid;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
