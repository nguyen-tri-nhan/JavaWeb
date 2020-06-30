/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.dtos;

/**
 *
 * @author nguyentrinhan2000
 */
public class ErrorUserDTO {
    private String errorid, errorname, errorpassword, errorrepassword, errorrole;

    public ErrorUserDTO() {
    }

    public ErrorUserDTO(String errorid, String errorname, String errorpassword, String errorrepassword, String errorrole) {
        this.errorid = errorid;
        this.errorname = errorname;
        this.errorpassword = errorpassword;
        this.errorrepassword = errorrepassword;
        this.errorrole = errorrole;
    }

    public String getErrorid() {
        return errorid;
    }

    public void setErrorid(String errorid) {
        this.errorid = errorid;
    }

    public String getErrorname() {
        return errorname;
    }

    public void setErrorname(String errorname) {
        this.errorname = errorname;
    }

    public String getErrorpassword() {
        return errorpassword;
    }

    public void setErrorpassword(String errorpassword) {
        this.errorpassword = errorpassword;
    }

    public String getErrorrepassword() {
        return errorrepassword;
    }

    public void setErrorrepassword(String errorrepassword) {
        this.errorrepassword = errorrepassword;
    }

    public String getErrorrole() {
        return errorrole;
    }

    public void setErrorrole(String errorrole) {
        this.errorrole = errorrole;
    }

    
    
}
