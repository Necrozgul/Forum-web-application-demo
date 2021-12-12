<%@ page import="com.example.forum.model.User" %>
<%@ page import="com.example.forum.model.Forum" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.forum.model.Comment" %><%--
  Created by IntelliJ IDEA.
  User: msand
  Date: 2021. 12. 03.
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
<h1>Members</h1>
<h2>Hello <%=((User)session.getAttribute("user")).getEmail()+((User)session.getAttribute("user")).getId()%></h2>
<h2>Fórum:</h2>
<%
    User u= Forum.getInstance().findUserByNick(((User)session.getAttribute("user")).getNickname());
    ArrayList<User> users = Forum.getInstance().getUsers();
    ArrayList<Comment> comments = Forum.getInstance().getComments();
    StringBuilder sb = new StringBuilder();
    sb.append(Forum.getInstance().getCommentText());
%>
        <%=sb.toString()%>

<form action="/register" method="post">
    <i style="display: <%=session.getAttribute("displayerror")%>">Comment cant be empty!</i><br>
             <input type="hidden" name="id" value="<%=u.getId()%>"><br>
    Comment: <input type="text" name="commenttext" value="test"><br>
    <input type="submit" value="comment"><br>
</form>


</body>
</html>
