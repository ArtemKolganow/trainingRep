<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 06.05.2020
  Time: 15:58
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
    <title>Edit profile</title>

</head>
<body>
<c:url value="/NewPass.html" var="newPassURL"/>
<c:url value="/NewUserInfo.html" var="newUserInfoURL"/>
<jsp:useBean id="authorizedUser" scope="session" class="by.training.finalproject.entity.User"/>
<c:url value="/LogOut.html" var="logOunURL"/>
<c:url value="/Basket.html" var="basketURL"/>
<c:url value="/profile.html" var="profileURL"/>
<nav class="navbar navbar-light" style="background-color: #CFCFDF">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">WorkShop</a>
    <form class="form-inline">
        <a class="btn form-control btn-sm align-middle btn-outline-secondary" href="${basketURL}">Basket</a>
        <c:if test="${authorizedUser.login != null}">
            Hello: <a href="${profileURL}">${authorizedUser.login}</a>
            <a class="btn form-control btn-sm align-middle btn-outline-secondary" href="${logOunURL}">Log out</a>
        </c:if>
    </form>
</nav>
<div class="text-center">
    <FORM action="${newPassURL}" method="post" style="margin: 100px auto auto" >
        <label for="oldPassword"></label><INPUT type="password" id="oldPassword" name="oldPassword" placeholder="Old Password"><br>
        <label for="newPassword"></label><INPUT type="password" id="newPassword" name="newPassword" placeholder="New Password"><br>
        <label for="confirmPassword"></label><INPUT type="password" id="confirmPassword" name="confirmPassword" placeholder="One more time password"><br><br>
        <BUTTON class="btn  btn-sm align-middle btn-outline-secondary" type="submit" style="width: 20%">Change password</BUTTON>
    </FORM>
</div>
<br>

<div class="text-center">
    <FORM action="${newUserInfoURL}" method="post" style="margin: 100px auto auto" >
        <label for="name"></label><INPUT type="text" id="name" name="name" placeholder="Name"><br>
        <label for="surname"></label><INPUT type="text" id="surname" name="surname" placeholder="Surname"><br>
        <label for="phoneNumber"></label><INPUT type="text" id="phoneNumber" name="phoneNumber" placeholder="Phone number"><br>
        <BUTTON class="btn  btn-sm align-middle btn-outline-secondary" type="submit" style="width: 20%">Edit user info</BUTTON>
    </FORM>
</div>

</body>
</html>
