/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.dtos;

import java.sql.Date;

/**
 *
 * @author Lenovo
 */
public class OrderDTO {

    private String orderid, userid;
    private Date orderdate, returndate;
    private boolean returned;
    private int required;

    public OrderDTO() {
    }

    public OrderDTO(String orderid, String userid, Date orderdate, Date returndate, boolean returned, int required) {
        this.orderid = orderid;
        this.userid = userid;
        this.orderdate = orderdate;
        this.returndate = returndate;
        this.returned = returned;
        this.required = required;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Date getReturndate() {
        return returndate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public int getRequired() {
        return required;
    }

    public void setRequired(int required) {
        this.required = required;
    }

    
    
}
