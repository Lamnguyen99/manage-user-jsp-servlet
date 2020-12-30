<%-- 
    Document   : editUser
    Created on : Jul 20, 2020, 7:33:39 AM
    Author     : lamde
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
            <h1>Edit User</h1>  
            <form action ="edit2" method="POST">
                <table>
                    <tr>
                        <td>
                            <input type='hidden' name='id' value = "${user.getUserID()}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Email: </td><td><input type='text' name='email' value="${user.getEmail()}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Password:</td><td><input type='password' name='password' value="${user.getPassword()}"/>  
                        </td>
                    </tr>
                    <tr>
                        <td>
                            FirstName</td><td><input type='text' name='firstName' value="${user.getFirstName()}"/>  
                        </td>
                    </tr>
                    <tr>
                        <td>
                            LastName</td><td><input type='text' name='lastName' value="${user.getLastName()}"/>  
                        </td>
                    </tr>
                    <tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>
                </table>
            </form>
            <br/>  
            <a href="./list">view users</a>  
        </center>
    </body>
</html>
