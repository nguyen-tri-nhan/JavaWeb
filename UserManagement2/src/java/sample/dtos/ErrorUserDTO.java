/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dtos;

/**
 *
 * @author nguyentrinhan2000
 */
public class ErrorUserDTO {
    private String ErrorUserID, ErrorfullName, ErrorPassword, ErrorRePassword, ErrorroleID;

    public ErrorUserDTO() {
    }

    public ErrorUserDTO(String ErrorUserID, String ErrorfullName, String ErrorPassword, String ErrorRePassword, String ErrorroleID) {
        this.ErrorUserID = ErrorUserID;
        this.ErrorfullName = ErrorfullName;
        this.ErrorPassword = ErrorPassword;
        this.ErrorRePassword = ErrorRePassword;
        this.ErrorroleID = ErrorroleID;
    }

    public String getErrorUserID() {
        return ErrorUserID;
    }

    public void setErrorUserID(String ErrorUserID) {
        this.ErrorUserID = ErrorUserID;
    }

    public String getErrorfullName() {
        return ErrorfullName;
    }

    public void setErrorfullName(String ErrorfullName) {
        this.ErrorfullName = ErrorfullName;
    }

    public String getErrorPassword() {
        return ErrorPassword;
    }

    public void setErrorPassword(String ErrorPassword) {
        this.ErrorPassword = ErrorPassword;
    }

    public String getErrorRePassword() {
        return ErrorRePassword;
    }

    public void setErrorRePassword(String ErrorRePassword) {
        this.ErrorRePassword = ErrorRePassword;
    }

    public String getErrorroleID() {
        return ErrorroleID;
    }

    public void setErrorroleID(String ErrorroleID) {
        this.ErrorroleID = ErrorroleID;
    }
    

    
}
