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
    <title>WorkShop main</title>

</head>
<body>
<jsp:useBean id="authorizedUser" scope="session" class="by.training.finalproject.entity.User"/>
<c:url value="/SignIn.html" var="signInURL"/>
<c:url value="/LogOut.html" var="logOunURL"/>
<c:url value="/Basket.html" var="basketURL"/>
<c:url value="/profile.html" var="profileURL"/>
<c:url value="/ToOrder.html" var="orderURL"/>
<c:url value="/ToRegistration.html" var="ToRegistrationURL"/>
<nav class="navbar navbar-light" style="background-color: #CFCFDF">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">WorkShop</a>
    <form class="form-inline">
        <a class="btn form-control btn-sm align-middle btn-outline-secondary" href="${basketURL}">Basket</a>
        <c:if test="${authorizedUser.login == null}">
            <a class="btn form-control btn-sm align-middle btn-outline-secondary" href="${ToRegistrationURL}">Registration</a>
            <a class="btn form-control btn-sm align-middle btn-outline-secondary" href="${signInURL}"> Sign In</a>
        </c:if>
      <c:if test="${authorizedUser.login != null}">
        Hello:  <a href="${profileURL}">${authorizedUser.login}</a>
          <a class="btn form-control btn-sm align-middle btn-outline-secondary" href="${logOunURL}">Log out</a>
      </c:if>
    </form>
</nav>
<jsp:useBean id="productList" scope="request" type="java.util.List"/>
<div class="container mt-5">
    <div class="row row-cols-1 row-cols-md-3">
    <c:forEach var="product" items="${productList}">
        <div class="col mb-4">
        <div class="card h-100">
            <c:url value="${product.image}" var="img"/>
            <img class="img-fluid" style="max-height: 250px" src="${img}" alt="NO IMAGE">
            <div class="card-body  d-flex flex-column">
                <h5 class="card-title">${product.name}</h5>
                <p class="card-text">Type: ${product.type}<br> Price: ${product.price}</p>
                <div class="card-footer"  style="margin-top: auto">
                    <form action="${orderURL}">
                        <input type="hidden" id="id" name="id" value="${product.id}">
                        <label for="quantity"></label><input type="number" style="max-width: 100%" min="0" step="1" id="quantity" name="quantity" value="1">
                        <button class="btn form-control btn-sm align-middle btn-outline-secondary" type="submit">To order.</button>
                    </form>
                </div>

            </div>
        </div>
      </div>
    </c:forEach>
  </div>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>
