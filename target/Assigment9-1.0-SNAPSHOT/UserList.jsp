<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User List</title>
        <link href="styles/newcss.css" rel="stylesheet">
    </head>
    <body>
        <center>
            <h2>Hello ${userr.getFirstName()} ${userr.getLastName()}</h2>
            <a href="./logout">Logout</a>
            <h1 style="color: cadetblue">User Management</h1>
                <a href="./insert">Add New User</a>
                &nbsp;&nbsp;&nbsp;
                <a href="./list">List All User</a>
        </center>
            <br>
        <div align="center">
            <div id ="searchNav">
                <form action = "search" method ="POST">
                    <tr>
                        <td ><b>Email: </b></td>
                        <td><input  type="text" name="pid"></td>
                    </tr>  
                    <input type="submit" name="submit" value="Search">
                </form>
            </div>
            <br>
            <table border="1" cellpadding="5">
                <tr>
                    <th>Email</th>
                    <th>FirstName</th>
                    <th>LastName</th>
                    <th></th>
                <br>
                </tr>

                <c:forEach var="item" items="${lists}">
                    <tr>
                        <td>${item.getEmail()}</td>
                        <td>${item.getFirstName()}</td>
                        <td>${item.getLastName()}</td>
                        <td>
                            <a href="./edit?id=<c:out value='${item.getUserID()}' />">Edit</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="./delete?id=<c:out value='${item.getUserID()}' />">Delete</a>  
                        </td>
                    </tr> 
                </c:forEach>
            </table>
        </div>
    </body>
</html>
