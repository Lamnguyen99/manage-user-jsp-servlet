<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>  
<html>  
    <head>  
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>  
    </head>  
<body>  
<center>
    <h1>Add New User</h1>  
    <form action="insert" method="post">  
        <table>  
            <tr>
                <td>Email:</td><td><input type="email" name="email"/></td>
            </tr>
            <tr>
                <td>Password:</td><td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td>FirstName:</td><td><input type="text" name="firstName"/></td>
            </tr> 
            <tr>
                <td>LastName:</td><td><input type="text" name="lastName"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"/></td>
            </tr>  
        </table>  
    </form>
<br/>  
<a href="./list">view users</a>  
</center>  
  
</body>  
</html>  