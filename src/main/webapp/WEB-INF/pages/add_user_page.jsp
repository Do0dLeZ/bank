<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>
<c:url value="/add_user" var="addUser"/>
<form action="${addUser}" method="post">
    Name:           <input type="text" name="name" placeholder="enter user name..."><br/>
    Surname:        <input type="text" name="surname" placeholder="enter user name..."><br/>
    Email:          <input type="text" name="email" placeholder="enter user name..."><br/>
    Phone:          <input type="text" name="phone" placeholder="enter user name..."><br/>
    User login:     <input type="text" name="login" id="user-login"><br/>
    User password:  <input type="password" name="password" id="user-password"><br/>
    Roles:  <select name="role">
                <c:forEach items="${roles}" var="role">
                    <option value="${role}">${role}</option>
                </c:forEach>
            </select>
    <input type="submit" value="Save">
</form>
</body>
</html>