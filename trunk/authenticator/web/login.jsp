<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>

    <h1>Login Page</h1>
    
    <table border="1" width="25%">
        <thead>
            <tr><th> </th></tr>
        </thead>
        <tbody>
            <tr><td> Username: </td></tr>
            <tr><td> <input type="text" name="username" value="" size="100%" /> </td></tr>
            <tr><td> Password: </td></tr>
            <tr><td> <input type="password" name="password" value="" /> </td></tr>
            <tr><td> <input type="submit" value="Submit" name="submit" /> </td></tr>
            <tr><td> &nbsp;</td></tr>
            <tr><td> <a href="forgotPassword.jsp">Forgot password ? </a></td></tr>
            <tr><td> &nbsp;</td></tr>
            <tr><td> Not registered yet, <a href="registration.jsp">Join now</a></td></tr>
        </tbody>
    </table>
        
    </body>
</html>
