<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <c:url value="/j_spring_security_check" var="loginUrl"/>
    <form action="${loginUrl}" method="post">
        Login: <input type="text" name="j_login"><br/>
        Password: <input type="password" name="j_password"><br/>
        <input type="submit">
    </form>
</body>
</html>
