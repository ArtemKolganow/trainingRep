<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Basket</title>

</head>
<body>
<jsp:useBean id="authorizedUser" scope="session" class="by.training.finalproject.entity.User"/>
<c:url value="/SignIn.html" var="signInURL"/>
<c:url value="/LogOut.html" var="logOunURL"/>
<c:url value="/ConfirmOrder.html" var="confirmURL"/>
<c:url value="/ChangeOrder.html" var="changeURL"/>
<c:url value="/profile.html" var="profileURL"/>
<c:url value="/ToRegistration.html" var="ToRegistrationURL"/>
<nav class="navbar navbar-light" style="background-color: #CFCFDF">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">WorkShop</a>
    <form class="form-inline">
        <c:if test="${authorizedUser.login == null}">
            <a class="btn form-control btn-sm align-middle btn-outline-secondary" href="${ToRegistrationURL}">Registration</a>&nbsp;
            <a class="btn form-control btn-sm align-middle btn-outline-secondary" href="${signInURL}"> Sign In</a>
        </c:if>
        <c:if test="${authorizedUser.login != null}">
            Hello:&nbsp;  <a href="${profileURL}">${authorizedUser.login}</a>&nbsp;
            <a class="btn form-control btn-sm align-middle btn-outline-secondary" href="${logOunURL}">Log out</a>
        </c:if>
    </form>
</nav>
<jsp:useBean id="productList" scope="request" type="java.util.List"/>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Image</th>
        <th scope="col">Name</th>
        <th scope="col">Type</th>
        <th scope="col">Weight</th>
        <th scope="col">Materials</th>
        <th scope="col">Price</th>
        <th scope="col">Quantity</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="registeredProduct" items="${productList}">
        <tr>
            <c:url value="${registeredProduct.product.image}" var="image"/>
            <th scope="row"><img class="img-fluid" style="max-height: 100px; max-width: 100px" src="${image}" alt="NO IMAGE"></th>
            <td>${registeredProduct.product.name}</td>
            <td>${registeredProduct.product.type}</td>
            <td>${registeredProduct.product.weight}</td>
            <td>
                <c:forEach var="material" items="${registeredProduct.product.materials}">
                    ${material},&nbsp;
                </c:forEach>
            </td>
            <td>${registeredProduct.product.price}</td>
            <td>${registeredProduct.quantity}</td>
        </tr>
    </c:forEach>


    </tbody>
</table>
<h3></h3>

<a class="btn form-control btn-sm align-middle btn-outline-secondary" href="${confirmURL}">Confirm order</a>
<a class="btn form-control btn-sm align-middle btn-outline-secondary" href="${changeURL}">Change order</a>


</body>
</html>
