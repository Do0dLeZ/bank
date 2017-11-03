<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
</head>
<body>
    <c:url value="/add_user_page" var="addUser"/>
    <form action="${addUser}">
        <a href="${addUser}">Add user...</a>
    </form>

    <c:url value="/logout" var="logoutUrl"/>
    <a href="${logoutUrl}" >Click to logout.</a>
</body>
</html>
