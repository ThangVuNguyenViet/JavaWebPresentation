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
public class ChangePasswordInvalid implements Serializable{
    private String oldPasswordInvalid, newPasswordInvalid, confirmPasswordInvalid;

    public String getOldPasswordInvalid() {
        return oldPasswordInvalid;
    }

    public void setOldPasswordInvalid(String oldPasswordInvalid) {
        this.oldPasswordInvalid = oldPasswordInvalid;
    }

    public String getNewPasswordInvalid() {
        return newPasswordInvalid;
    }

    public void setNewPasswordInvalid(String newPasswordInvalid) {
        this.newPasswordInvalid = newPasswordInvalid;
    }

    public String getConfirmPasswordInvalid() {
        return confirmPasswordInvalid;
    }

    public void setConfirmPasswordInvalid(String confirmPasswordInvalid) {
        this.confirmPasswordInvalid = confirmPasswordInvalid;
    }
    
}
