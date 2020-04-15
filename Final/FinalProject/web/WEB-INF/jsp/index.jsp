<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="ctg" uri="customtags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 20.03.2020
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Main</title>
  </head>
  <body>
  <ctg:info-time/>
  <c:url value="/SignIn.html" var="loginUrl"/>
  <FORM action="${loginUrl}" method="post">
    <BUTTON type="submit">Go to LogIn</BUTTON>
  </FORM>
  </body>
</html>
