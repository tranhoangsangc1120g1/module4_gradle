<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/31/2021
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create New Email</title>
</head>
<body>
<form:form method="POST" action="/update" modelAttribute="email">
    <table>
        <tr>
            <td><label > Language: </label></td>
            <td><form:select path="language">
                <form:options items="${languageList}"/>
            </form:select>
            </td>
        </tr>
        <tr>
            <td><label>Page Size : </label></td>
            <td><form:select path="pageSize" items="${pageSizeList}"/></td>
        </tr>
        <tr>
            <td><label>Spams Filters </label></td>
            <td><form:checkbox path="spamsFilter"/></td>
        </tr>
        <tr>
            <td><label>Signature : </label></td>
            <td><form:textarea path="signature" cols="50" rows="4"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="update"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
