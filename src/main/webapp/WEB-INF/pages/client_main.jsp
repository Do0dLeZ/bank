<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
</head>
<body>
<c:url value="/logout" var="logoutUrl"/>
<a href="${logoutUrl}">Click to logout.</a>

Choose account to transfer rom:
<select name="from">
    <c:forEach items="${accounts}" var="account">
        <option name="${account.id}">${account.id + " " + account.currency.currencyName}</option>
    </c:forEach>
</select>

<h3>Currency rates for today</h3><br/>
<table border="1">
    <thead>
    <tr>
        <td>From</td>
        <td>To</td>
        <td>Coefficient</td>
    </tr>
    <c:forEach items="${currencyRates}" var="rate">
        <tr>
            <td>${rate.from.currencyName}</td>
            <td>${rate.to.currencyName}</td>
            <td>${rate.value}</td>
        </tr>
    </c:forEach>
    </thead>
</table>

<h3>Transfer inside</h3><br/>
<c:url value="/transfer/inside" var="transferInside"/>
<form action="${transferInside}" method="post">
    Sum: <input type="number" name="value" id="sum-inside" step=0.01><br/>
    Account to refill:
    <select name="toInside">
        <c:forEach items="${accounts}" var="account">
            <option name="${account.id}">${account.id + " " + account.currency.currencyName}</option>
        </c:forEach>
    </select><br/>
    <input type="submit" value="Transfer" name="transfer-inside"><br/>
</form>

<h3>Transfer to another client</h3><br/>
<c:url value="/transfer/toClient" var="transferToClient"/>
<form action="${transferToClient}" method="post">
    Sum: <input type="number" name="value" id="sum-to-client" step=0.01><br/>
    Client account: <input type="text" name="client-account" id="client-account"><br/>
    <input type="submit" value="Transfer"><br/>
</form>
</body>
</html>