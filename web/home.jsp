<%--
  Created by IntelliJ IDEA.
  User: Mid
  Date: 13.09.2018
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.mkaz.model.*" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<center>
    Welcome
    <mark><%=session.getAttribute("nickname")%><br></mark>
    Articles:
    <%List<Article> articles = (List<Article>) session.getAttribute("articles");%>
    <%articles.sort(new DateComparator());%>
    <table border="1">
        <tr>
            <th>
                Title:
            </th>
            <th>
                Text:
            </th>
            <th>
                Date:
            </th>
            <th>
                Author:
            </th>
            <th>
                Options:
            </th>

        </tr>
        <%for (Article article : articles) {%>
        <tr>
            <td>
                <%=article.getTitle()%>
            </td>
            <td>
                <%=article.getText()%>
            </td>
            <td>
                <%=article.getDate()%>
            </td>
            <td>
                <%=article.getUser().getNickname()%>
            </td>
            <td>
                <div style="text-align: center;">
                    <%
                        if (session.getAttribute("nickname").equals("admin") ||
                                article.getUser().getNickname().equals(session.getAttribute("nickname"))) {
                    %>
                    <form action="/edit" method="POST">
                        <input type="hidden" name="title" value="<%=article.getTitle()%>">
                        <input type="submit" value="Edit"/>
                    </form>
                    <form action="/delete" method="POST">
                        <input type="hidden" name="title" value="<%=article.getTitle()%>">
                        <input type="submit" value="Delete"/>
                    </form>
                    <%}%>
                </div>
            </td>
        </tr>
        <%}%>
    </table>
    <center>
        <form action="/add" method="POST">
            <input type="submit" value="Add"/>
        </form>
    </center>
</center>
</body>
</html>
