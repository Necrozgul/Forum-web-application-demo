package com.example.forum.controller;

import com.example.forum.model.Comment;
import com.example.forum.model.Forum;
import com.example.forum.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class WebController {

    @GetMapping("/")
    public String loadIndex(HttpSession session) {
        session.setAttribute("displayerror", "none");
        return "index.jsp";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("nick") String nick, @RequestParam("password") String password, HttpSession session) {
        if(!nick.isEmpty() || !password.isEmpty())
        {
            User u = Forum.getInstance().findUserByNick(nick);
            if (u!=null)
            {
                if(u.getPassword().equals(password))
                {
                    session.setAttribute("user", u);
                    return "main.jsp";
                }
                else {
                    return "redirect:/invalid.html";
                }
            }
            else
            {
                session.setAttribute("displayerror", "block");
                return "index.jsp";
            }

        }
        else {
            return "redirect:/invalid.html";
        }
    }

    @PostMapping("/register")
    public String registerNewUser(@RequestParam("commenttext") String text, @RequestParam("id") Integer id, HttpSession session)
    {
        if(!text.isEmpty()) {
                Comment c = new Comment(id,text);
                Forum.getInstance().addComment(c);
                session.setAttribute("comment", c);

        }
        return "main.jsp";
    }

}
