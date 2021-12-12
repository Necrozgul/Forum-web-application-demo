package com.example.forum.model;

import java.util.ArrayList;

public class Forum {
    private static Forum self;
    private ArrayList<User> users;
    private ArrayList<Comment> comments;

    public Forum() {
        users = new ArrayList<>();
        comments = new ArrayList<>();
        users.add(new User("testlaci", "test","test@test.com","test"));
        users.add(new User("aname", "a","a@a.com","a"));
        comments.add(new Comment(1,"Első comment"));
        comments.add(new Comment(1,"Második comment"));
        comments.add(new Comment(2,"Harmadik comment"));
        comments.add(new Comment(2,"Negyedik comment"));

    }

    public static Forum getInstance() {
        if(self == null)
        {
            self = new Forum();
        }
        return self;
    }
    public ArrayList<User> getUsers() {
        return users;
    }
    public void addUser(User u) {
        users.add(u);
    }
    public void addComment(Comment c)
    {
        comments.add(c);
    }
    public ArrayList<Comment> getComments() {
        return comments;
    }
    public User findUserById(Integer id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }
    public User findUserByNick(String nick) {
        return users.stream().filter(u -> u.getNickname().equals(nick)).findFirst().orElse(null);
    }
    public String getCommentNickById(Integer id)
    {
        return comments.stream().filter(u -> u.getUserid().equals(id)).findFirst().orElse(null).toString();
    }
    public String getCommentText()
    {
        String text="";
        for (Comment c:comments
             ) {
            String user="";
            if (Forum.getInstance().findUserById(c.userid).getNickname()!=null)
            {
                user = Forum.getInstance().findUserById(c.userid).getNickname();
            }
            text+="<br>"+ user +" - "+c.text;

        }
        return text;
    }
}
