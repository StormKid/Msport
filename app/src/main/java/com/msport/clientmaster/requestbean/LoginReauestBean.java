package com.msport.clientmaster.requestbean;

import java.io.Serializable;

/**
 * Created by like on 2016/7/29.
 */

public class LoginReauestBean implements Serializable {

    private String telephone;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    private String password;

}
