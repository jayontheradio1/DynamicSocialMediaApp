package com.example.login;

public class Up {

    public String userYear;
    public String userEmail;
    public String userName;
    public String userAdmin;


    public Up() {
    }

    public Up(String userYear, String userEmail, String userName, String userAdmin) {
        this.userYear = userYear;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userAdmin = userAdmin;
    }


    public String getUserYear() {
        return userYear;
    }

    public void setUserYear(String userYear) {
        this.userYear = userYear;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAdmin() {
        return userAdmin;
    }

    public void setUserAdmin(String userAdmin) {
        this.userAdmin = userAdmin;
    }
}
