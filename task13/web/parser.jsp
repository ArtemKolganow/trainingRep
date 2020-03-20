<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 08.03.2020
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setBundle basename="properties.text" var="rb" />
<jsp:useBean id="language" scope="request" type="java.lang.String"/>
<fmt:setLocale value="${language}" scope="session" />
<html>
<head>
    <title><fmt:message key="title" bundle="${ rb }" /></title>
</head>
<body>
<jsp:useBean id="name" scope="request" type="java.lang.String"/>
<h1><fmt:message key="${name}" bundle="${ rb }" /></h1>
<jsp:useBean id="list" scope="request" type="java.util.List"/>
<c:forEach var="user" items="${list}">
    <p>
        ${user}
    </p>
</c:forEach>
<br>

</body>
</html>
