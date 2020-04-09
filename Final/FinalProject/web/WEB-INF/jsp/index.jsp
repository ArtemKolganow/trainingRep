<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="ctg" uri="customtags" %>
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
  <form action="${pageContext.request.contextPath}/WEB-INF/jsp/index.jsp" method="get">
    <button value="allUsers">All users</button>
  </form>
  <form action="${pageContext.request.contextPath}/WEB-INF/jsp/index.jsp" method="get">
    <p>Input ID: </p>
    <label>
      <input name="id" type="text" size="15">
    </label>
    <input type="submit" value="Send">
  </form>
  </body>
</html>
