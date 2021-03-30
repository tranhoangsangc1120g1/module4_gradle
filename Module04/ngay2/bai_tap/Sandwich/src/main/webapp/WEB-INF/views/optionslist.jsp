<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/30/2021
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Select Options</h3>
<form action="/save" method="get">

<input type="checkbox" name="condiment" value="lettuce"><span>Lettuce</span>
<input type="checkbox"  name="condiment" value="Tomato"><span>Tomato</span>
<input type="checkbox"  name="condiment" value="Mustard"><span>Mustard</span>
<input type="checkbox" name="condiment"  value="Sprouts"><span>Sprouts</span>
<input type="submit" name="save">
    <p>Selected Options :
<c:forEach items="${condiment}" var="selection">
    <h1> ${selection}</h1>
</c:forEach>
    </p>
</form>
</body>
</html>
