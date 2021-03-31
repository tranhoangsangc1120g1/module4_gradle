<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/31/2021
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="table">

    <tr>
        <th>Language :</th>
        <td>${email.language}</td>
    </tr>
    <tr>
        <th>Page Size :</th>
        <td>${email.pageSize}</td>
    </tr>
    <tr>
        <th>Spams Filter:</th>
        <td>${email.spamsFilter}</td>
    </tr>
    <tr>
        <th>Signature :</th>
        <td>${email.signature}</td>
    </tr>
</table>
</body>
</html>
