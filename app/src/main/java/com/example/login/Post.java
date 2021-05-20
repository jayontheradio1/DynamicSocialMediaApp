package com.example.login;

import com.google.firebase.database.ServerValue;

public class Post {

    private String title;
    private String description;
    private String picture;
    private String userID;
    private String postKey;

    private Object timeStamp;

    public Post(String title, String description, String picture, String userID) {
        this.title = title;
        this.description = description;
        this.picture = picture;
        this.userID = userID;
        this.timeStamp = ServerValue.TIMESTAMP;
    }

    public Post() {
    }

    public String getPostKey() {
        return postKey;
    }

    public void setPostKey(String postKey) {
        this.postKey = postKey;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPicture() {
        return picture;
    }

    public String getUserID() {
        return userID;
    }



    public Object getTimeStamp() {
        return timeStamp;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }



    public void setTimeStamp(Object timeStamp) {
        this.timeStamp = timeStamp;
    }
}
