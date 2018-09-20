<%@ page import="com.mkaz.model.Article" %><%--
  Created by IntelliJ IDEA.
  User: Mid
  Date: 15.09.2018
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%Article article = (Article) session.getAttribute("article");%>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<center>
    <table border="1">
        <td>
            <form action="/save" method="POST">
                <textarea rows="30" cols="80" name="text"><%=article.getText()%></textarea><br>
                <input type="hidden" name="title" value="<%= article.getTitle()%>">
                <center><input type="submit" value="Save"/></center>
            </form>
        </td>
    </table>
</center>
</body>
</html>