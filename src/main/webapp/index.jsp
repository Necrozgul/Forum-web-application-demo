<%--
  Created by IntelliJ IDEA.
  User: msand
  Date: 2021. 12. 03.
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form action="/login" method="post">
    <i style="display: <%=session.getAttribute("displayerror")%>">Nickname doesnt exists!</i><br>
    Username: <input type="text" name="nick" value="test"><br>
    Password: <input type="password" name="password" value="test"><br>
    <input type="submit" value="Login"><br>
</form>
</body>
</html>
