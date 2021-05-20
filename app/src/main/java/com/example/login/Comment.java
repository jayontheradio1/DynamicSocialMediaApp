package com.example.login;

import com.google.firebase.database.ServerValue;

public class Comment {

    private String content,uid,username;
    private Object timestamp;


    public Comment() {
    }

    public Comment(String content, String uid, String username) {
        this.content = content;
        this.uid = uid;
        this.username = username;
        this.timestamp = ServerValue.TIMESTAMP;
    }

    public Comment(String content, String uid, String username, Object timestamp) {
        this.content = content;
        this.uid = uid;
        this.username = username;
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Object getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Object timestamp) {
        this.timestamp = timestamp;
    }
}
