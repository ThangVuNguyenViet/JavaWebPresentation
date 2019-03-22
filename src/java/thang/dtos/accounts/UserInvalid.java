/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.dtos.accounts;

/**
 *
 * @author Thang
 */
public class UserInvalid {
    private String usernameInvalid, fullnameInvalid, phoneInvalid, emailInvalid, addressInvalid;

    public String getUsernameInvalid() {
        return usernameInvalid;
    }

    public void setUsernameInvalid(String usernameError) {
        this.usernameInvalid = usernameError;
    }

    public String getFullnameInvalid() {
        return fullnameInvalid;
    }

    public void setFullnameInvalid(String fullnameError) {
        this.fullnameInvalid = fullnameError;
    }

    public String getPhoneInvalid() {
        return phoneInvalid;
    }

    public void setPhoneInvalid(String phoneberError) {
        this.phoneInvalid = phoneberError;
    }

    public String getEmaiInvalid() {
        return emailInvalid;
    }

    public void setEmailInvalid(String emailError) {
        this.emailInvalid = emailError;
    }

    public String getAddressInvalid() {
        return addressInvalid;
    }

    public void setAddressInvalid(String addressError) {
        this.addressInvalid = addressError;
    }
    
}
