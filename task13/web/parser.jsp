<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 08.03.2020
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Parser is open</title>
</head>
<body>
<jsp:useBean id="list" scope="request" type="java.util.List"/>
<c:forEach var="user" items="${list}">
    <p>
        ${user}
    </p>
</c:forEach>
</body>
</html>
