package com.example.login;

public class UserProfile {

    public String userYear;
    public String userEmail;
    public String userName;

    public UserProfile(){

    }

    public UserProfile(String userAge, String userEmail, String userName) {
        this.userYear = userAge;
        this.userEmail = userEmail;
        this.userName = userName;
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



}
