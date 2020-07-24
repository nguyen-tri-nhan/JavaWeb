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
public class UserDTO {
    private String id, fullName, password, role;

    public UserDTO() {
    }

    public UserDTO(String UserID, String fullName, String password, String role) {
        this.id = UserID;
        this.fullName = fullName;
        this.password = password;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

   
    
}
