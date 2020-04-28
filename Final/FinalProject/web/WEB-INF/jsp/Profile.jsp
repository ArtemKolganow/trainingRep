<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 23.04.2020
  Time: 18:04
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
    <title>WorkShop profile</title>
</head>
<body>
<jsp:useBean id="authorizedUser" scope="session" class="by.training.finalproject.entity.User"/>
<c:url value="/SignIn.html" var="signInURL"/>
<c:url value="/ToRegistration.html" var="ToRegistrationURL"/>
<c:url value="/LogOut.html" var="logOunURL"/>
<c:url value="/EditProfile.html" var="editURL"/>
<c:url value="/toOrderList.html" var="orderListURL"/>
<c:url value="/toCraftOrderList.html" var="craftOrderListURL"/>
<c:url value="/craftOrder.html" var="craftOrderURL"/>
<c:url value="/toAddProduct.html" var="toAddProductURL"/>
<c:url value="/toUserList.html" var="toUserListURL"/>
<nav class="navbar navbar-light" style="background-color: #CFCFDF">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">WorkShop</a>

</nav>
Login: ${authorizedUser.login}.<br>
Email: ${authorizedUser.email}.<br>
<c:if test="${authorizedUser.userInfo.name != null}">
    Name: ${authorizedUser.userInfo.name}<br>
    Surname: ${authorizedUser.userInfo.surname}<br>
    Phone number: ${authorizedUser.userInfo.phoneNumber}<br>
</c:if>
Role:
<c:if test="${authorizedUser.role == 0}">
    User.<br>
    <a class="btn form-control btn-sm align-middle btn-outline-secondary" href="${orderListURL}">To order list.</a><br>
    <a class="btn form-control btn-sm align-middle btn-outline-secondary" href="${craftOrderListURL}">To craft order list.</a><br>
    <a class="btn form-control btn-sm align-middle btn-outline-secondary" href="${craftOrderURL}">Create new craft order.</a><br>
</c:if>
<c:if test="${authorizedUser.role == 1}">
    Master.<br>
    <a class="btn form-control btn-sm align-middle btn-outline-secondary" href="${craftOrderListURL}">To craft order list.</a><br>
    <a class="btn form-control btn-sm align-middle btn-outline-secondary" href="${toAddProductURL}">Add new product.</a><br>

</c:if>
<c:if test="${authorizedUser.role == 2}">
    Admin.<br>
    <a class="btn form-control btn-sm align-middle btn-outline-secondary" href="${toUserListURL}">To user list.</a><br>

</c:if>
<br>

<a class="btn form-control btn-sm align-middle btn-outline-secondary" href="${editURL}">Edit profile.</a>


</body>
</html>
