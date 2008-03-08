<html>
    <head>
        
    </head>
    
    <body>
        <% if (request.getParameter("login_error") != null) {%> <b> <font color=RED> Sorry, but either the username or password is incorrect.
        </font></b> <% } %>
        
        <form action="j_acegi_security_check" method="POST">
            
            <p>Please login to obtain access to ur secure assets</p>
            
            <table>
                <tr><td>User:</td><td><input type='text' name='j_username'>  </td></tr>
                <tr><td>Password:</td><td><input type='password' name='j_password'> </td></tr>
                
                <tr><td/><td colspan='2'><input name="submit" value="Login" type="submit"></td></tr>
            </table>
            
        </form>
        
    </body>
</html>
