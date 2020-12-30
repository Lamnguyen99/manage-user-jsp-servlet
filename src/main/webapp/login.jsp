<%-- 
    Document   : Lsogin
    Created on : Jul 3, 2020, 6:52:14 PM
    Author     : lamde
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login to the system</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="styles/style1.css">
    </head>
    <body>
        <div id="container">
            <h1 class="box-title">Login to the system</h1>
            <%
		String err = request.getParameter("err");
		if ("1".equals(err)) {
			out.print("<h4 style=\"color: red;\">Login Fail</h4>");
		}
            %>
            <form action="login" method="post">
                    <div class="form-group">
                        <label>Email:</label>
                        <input type ="text" name="email"/>
                    </div>
                    <div class="form-group1">
                        <label>Password:</label>
                        <input type ="password" name="password"/>
                    </div>
                    <div class="form-group1">  
                        <input type ="checkbox" name="checkRemember" value="ON"/>
                        <label>Remember me?</label>
                    </div>
                    <div class="btn-box">
                        <button type="submit" value="login">Login
                    </div> 
                </form>
        </div>     
    </body>
</html>
