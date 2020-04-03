package com.szymou.homeassistant.dto;

import com.szymou.homeassistant.entity.User;

public class UserDto{
    private String uId;
    private String uName;
    private String uPassword;
    private String uMail;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuMail() {
        return uMail;
    }

    public void setuMail(String uMail) {
        this.uMail = uMail;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", uMail='" + uMail + '\'' +
                '}';
    }
}
