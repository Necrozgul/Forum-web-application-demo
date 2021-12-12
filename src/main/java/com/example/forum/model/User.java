package com.example.forum.model;

import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;
    String name;
    String nickname;
    String email;
    String password;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name, String nickname, String email, String password) {
        this.id = count.incrementAndGet();
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }
    public Integer idGenerator()
    {
        return this.id+1;
    }
}
