<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 23.04.2020
  Time: 19:36
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
    <title>Order list</title>
</head>
<body>
<c:url value="/toOrder.html" var="orderURL"/>
<jsp:useBean id="authorizedUser" scope="session" class="by.training.finalproject.entity.User"/>
<c:url value="/LogOut.html" var="logOunURL"/>
<c:url value="/profile.html" var="profileURL"/>

<nav class="navbar navbar-light" style="background-color: #CFCFDF">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">WorkShop</a>
    <form class="form-inline">
            Hello:  <a href="${profileURL}">${authorizedUser.login}</a>
            <a class="btn form-control btn-sm align-middle btn-outline-secondary" href="${logOunURL}">Log out</a>
    </form>
</nav>


<jsp:useBean id="orderList" scope="request" type="java.util.List"/>

<table class="table">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">Status</th>
        <th scope="col">Date</th>
        <th scope="col">Delivery date</th>
        <th scope="col">Price</th>
        <th scope="col">Go to order</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="order" items="${orderList}">
        <tr>
            <th scope="row">${order.id}</th>
            <td>${order.status}</td>
            <td>${order.date}</td>
            <td>${order.deliveryDate}</td>
            <td>${order.price}</td>
            <td><form action="${orderURL}">
                <input type="hidden" id="id" name="login" value="${order.id}">
                <button class="btn form-control btn-sm align-middle btn-outline-secondary" type="submit">Go to order.</button>
            </form> </td>
        </tr>
    </c:forEach>


    </tbody>
</table>
</body>
</html>
