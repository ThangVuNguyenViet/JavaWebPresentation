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
public class AccountInvalid {
    private String usernameInvalid, passwordInvalid;

    public AccountInvalid() {
    }

    public String getUsernameInvalid() {
        return usernameInvalid;
    }

    public void setUsernameInvalid(String usernameInvalid) {
        this.usernameInvalid = usernameInvalid;
    }

    public String getPasswordInvalid() {
        return passwordInvalid;
    }

    public void setPasswordInvalid(String passwordInvalid) {
        this.passwordInvalid = passwordInvalid;
    }   
}
