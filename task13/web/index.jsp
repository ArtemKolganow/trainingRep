<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 08.03.2020
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My parsers</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/parsers" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <h4>Language/Язык</h4>
    <input type="radio" name="language" value="ru_RU">Русский</input><br>
    <input type="radio" name="language" value="en_UA">English </input><br>
    <h4>Parser/Парсер</h4>
    <input type="radio" name="parser" value="stax">StAx</input><br>
    <input type="radio" name="parser" value="sax">SAX </input><br>
    <input type="radio" name="parser" value="dom">DOM </input><br>
    <input type="submit" value="Send"/>
</form>
</body>
</html>
