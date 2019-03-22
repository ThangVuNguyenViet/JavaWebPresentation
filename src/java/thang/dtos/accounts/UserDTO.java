/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.dtos.accounts;

import java.io.Serializable;

/**
 *
 * @author Thang
 */
public class UserDTO implements Serializable {
    private String username, fullname, phone, email, address;
    private int yob;
    private boolean gender;

    public UserDTO() {
    }

    public UserDTO(String username, String fullname, String phoneber, String email, String address, int yob, boolean gender) {
        this.username = username;
        this.fullname = fullname;
        this.phone = phoneber;
        this.email = email;
        this.address = address;
        this.yob = yob;
        this.gender = gender;
    }
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phoneber) {
        this.phone = phoneber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
    
    
}
