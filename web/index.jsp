<%@ page import="java.util.HashMap" %>
<%@ page import="com.mkaz.model.Article" %><%--
  Created by IntelliJ IDEA.
  User: Mid
  Date: 12.09.2018
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome!</title>
</head>
<body>
<form action="/home" method="POST">
    <center>
        <mark>Welcome on miniblog.com please login. Thank you.</mark><br>
        <p>Nickname: <input type="text" name="nickname"><br></p>
        <p>Password: <input type="password" name="password"><br></p>
        <input type="submit" value="Enter"></input></center>
</form>
</body>
</html>
