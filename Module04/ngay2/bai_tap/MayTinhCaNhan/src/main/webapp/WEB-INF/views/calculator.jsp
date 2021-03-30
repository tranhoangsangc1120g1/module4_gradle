<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/30/2021
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calculate" method="post">
    <input type="text" name="a" value="${a}">
    <select name="character">
        <option value="+">addition</option>
        <option value="-">subtraction</option>
        <option value="*">multiplication</option>
        <option value="/">division</option>
    </select>
    <input type="text" name="b" value="${b}">
    <input type="submit" value="OK">
    <c:if test="${c!=null}">
        <p>Result : ${c}</p>
    </c:if>

</form>
</body>
</html>
