package com.example.forum.model;

public class Comment {
    //Integer id;
    Integer userid;
    String text;

    public Comment(Integer userid, String text) {
        //this.id = id;
        this.userid = userid;
        this.text = text;
    }

    public Integer getUserid() {
        return userid;
    }
    public String getText() {
        return text;
    }

}
