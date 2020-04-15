<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 09.04.2020
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
</head>
<body>
<H2>Sign In</H2>
<c:url value="/login.html" var="loginUrl"/>
<FORM action="${loginUrl}" method="post">
    <LABEL for="login">User name:</LABEL>
    <INPUT type="text" id="login" name="login">
    <LABEL for="password">Password:</LABEL>
    <INPUT type="password" id="password" name="password">
    <BUTTON type="submit">Войти</BUTTON>
</FORM>
</body>
</html>
