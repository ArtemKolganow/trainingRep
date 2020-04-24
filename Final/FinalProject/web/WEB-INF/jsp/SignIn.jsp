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
    <meta charset="UTF-8">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>

    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <title>WorkShop login</title>
</head>
<body>
<c:url value="/login.html" var="loginUrl"/>
<jsp:useBean id="authorizedUser" scope="session" class="by.training.finalproject.entity.User"/>
<c:url value="/SignIn.html" var="signInURL"/>
<c:url value="/LogOut.html" var="logOunURL"/>
<nav class="navbar navbar-light" style="background-color: #CFCFDF">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">WorkShop</a>
    <form class="form-inline">
        <c:if test="${authorizedUser.login == null}">
            <a class="btn form-control btn-sm align-middle btn-outline-secondary" href="">Registration</a>
        </c:if>
        <c:if test="${authorizedUser.login != null}">
            Hello: <a href="">${authorizedUser.login}</a>
            <a class="btn form-control btn-sm align-middle btn-outline-secondary" href="${logOunURL}">Log out</a>
        </c:if>
    </form>
</nav>
<c:if test="${authorizedUser.login == null}">

    <div class="text-center">
        <h1>Sign In</h1>
            <FORM action="${loginUrl}" method="post" style="margin: 100px auto auto" >
                <label for="login"></label><INPUT type="text" id="login" name="login" placeholder="Login"><br>
                <label for="password"></label><INPUT type="password" id="password" name="password" placeholder="Password"><br><br>
                <BUTTON class="btn btn-sm align-middle btn-outline-secondary" type="submit" style="width: 20%">LogIn</BUTTON>
            </FORM>
    </div>
</c:if>
<c:if test="${authorizedUser.login != null}">
    <label style="margin: 75px 75px 75px">You are already logged in! </label>
</c:if>
</body>
</html>
