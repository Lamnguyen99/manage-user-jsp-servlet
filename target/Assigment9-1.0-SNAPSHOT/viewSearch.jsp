<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search User</title>
        <link href="styles/newcss.css" rel="stylesheet">
    </head>
    <body>
        <center>
            <h2>Hello ${user.firstName} ${user.lastName}</h2>
            <a href="./logout">Logout</a>
            <h1 style="color: cadetblue">User Management</h1>
                <a href="./addUser.jsp">Add New User</a>
                &nbsp;&nbsp;&nbsp;
                <a href="./list">List All User</a>
        </center>
            <br>
        <div align="center">
            <table border="1" cellpadding="5">
                <tr>
                    <b>Search User</b>
                </tr>
                <tr>
                    <th>Email</th>
                    <th>FirstName</th>
                    <th>LastName</th>
                </tr>
                <c:forEach var = "item" items="${listt}">
                    <tr>
                        <td>${item.getEmail()}</td>
                        <td>${item.getFirstName()}</td>
                        <td>${item.getLastName()}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>

