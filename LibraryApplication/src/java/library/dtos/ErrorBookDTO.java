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
public class ErrorBookDTO {
    private String errorbookcode, errortitle, errorauthor, errorquantity, errorprice;

    public ErrorBookDTO() {
    }

    public ErrorBookDTO(String errorbookcode, String errortitle, String errorauthor, String errorquantity, String errorprice) {
        this.errorbookcode = errorbookcode;
        this.errortitle = errortitle;
        this.errorauthor = errorauthor;
        this.errorquantity = errorquantity;
        this.errorprice = errorprice;
    }

    public String getErrorbookcode() {
        return errorbookcode;
    }

    public void setErrorbookcode(String errorbookcode) {
        this.errorbookcode = errorbookcode;
    }

    public String getErrortitle() {
        return errortitle;
    }

    public void setErrortitle(String errortitle) {
        this.errortitle = errortitle;
    }

    public String getErrorauthor() {
        return errorauthor;
    }

    public void setErrorauthor(String errorauthor) {
        this.errorauthor = errorauthor;
    }

    public String getErrorquantity() {
        return errorquantity;
    }

    public void setErrorquantity(String errorquantity) {
        this.errorquantity = errorquantity;
    }

    public String getErrorprice() {
        return errorprice;
    }

    public void setErrorprice(String errorprice) {
        this.errorprice = errorprice;
    }
    
}
