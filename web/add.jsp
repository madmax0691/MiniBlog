<%--
  Created by IntelliJ IDEA.
  User: Mid
  Date: 19.09.2018
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<form action="/save" method="POST">
    <center>
        <table border="1">
            <th>
                Title
            </th>
            <th>
                Text
            </th>
            <tr>
                <td>
                    <textarea rows="30" cols="80" name="title"></textarea>
                </td>
                <td>
                    <textarea rows="30" cols="80" name="text"></textarea>
                </td>
            </tr>
        </table>
    </center>
    <center><input type="submit" value="Save"/></center>
</form>
</body>
</html>
