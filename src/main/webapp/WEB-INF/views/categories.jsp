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
    <title>Categories</title>
</head>
<body>
<form action="categories/name" method="get">
    <label>Name: </label>
    <input type="text" name="name" placeholder="Search name">
    <input type="submit" name="search" value="Search">
</form>
<form action="http://localhost:8080/category_mvc_war/categories/create" method="get">
    <input type="submit" name="create" value="New">
</form>
<table style="border: 1px">
    <thead style="color: red; border: 1px">
    <tr style="color: red; border: 1px">
        <th>
            <center><b>Id</b></center>
        </th>
        <th>
            <center><b>Name</b></center>
        </th>
        <th>
            <center><b>Description</b></center>
        </th>
    </tr>
    </thead>
    <tbody style="border: 1px">
    <c:forEach var="category" items="${categories}">
        <tr style="border: 1px">
            <td>${category.id}</td>
            <td>${category.name}</td>
            <td>${category.description}</td>
            <td>
                <form action="http://localhost:8080/category_mvc_war/categories/update/${category.id}" method="get">
                    <input type="submit" name="edit" value="Edit">
                </form>
            </td>
            <td>
                <form action="categories/delete/${category.id}" method="post">
                    <input type="submit" name="delete" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
