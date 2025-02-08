<%--
  Created by IntelliJ IDEA.
  User: GHSalehova
  Date: 2/6/2025
  Time: 8:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add category</title>
</head>
<body>
<form action="http://localhost:8080/category_mvc_war/categories/create" method="post">
    <label>Id: </label>
    <input type="text" name="id"> <br/>
    <label>Name: </label>
    <input type="text" name="name"> <br/>
    <label>Description: </label>
    <input type="text" name="description"> <br/>
    <input type="submit" name="add" value="Add">
</form>
</body>
</html>
