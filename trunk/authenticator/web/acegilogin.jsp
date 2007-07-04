<html>
    <head>
        <title>Login</title>
    </head>
    
    <body>
        
        
        
        <% if ( request.getParameter("login_error") != null ) { %> <b> <font color=RED> Sorry, but either the username or password is incorrect.
        </font></b> <% } %>  
        
        
        <div id="login">
            
            <div id="gaia_loginbox">
                <table class="form-noindent" width="25%" cellspacing="3" cellpadding="5" border="0">
                    <tbody>
                        <tr>
                            <td valign="top" nowrap="nowrap" bgcolor="#e7eefa" style="text-align: center;">
                                <form action="j_acegi_security_check" method="POST">
                                    <table id="gaia_table" cellspacing="0" cellpadding="1" border="0" align="center">
                                        <tbody>
                                            <tr>
                                                <td align="center" colspan="2">
                                                    <font size="-1"> Please sign in here: </font>
                                                    <table>
                                                        <tbody>
                                                            <tr>
                                                                <td valign="top">
                                                                <img alt="My Software" src="google_transparent.gif"/></td>
                                                                <td valign="middle">
                                                                    <font size="-0">
                                                                <b>Account</b></font></td>
                                                            </tr>
                                                        </tbody>
                                                </table></td>
                                            </tr>
                                            
                                            <tr>
                                            <td align="center" colspan="2"/></tr>
                                            <tr>
                                                <td nowrap="nowrap">
                                                    <div align="right">
                                                <span class="gaia le lbl"> Username: </span></div></td>
                                                <td>
                                                <input type='text' name='j_username'>
                                                <!-- <input id="Email" class="gaia le val" type="text" value="" size="18" name="Email" style="background-color: rgb(255, 255, 160);"/></td>-->
                                            </tr>
                                            <tr>
                                                <td/>
                                            <td align="left"/></tr>
                                            <tr>
                                                <td align="right">
                                                <span class="gaia le lbl"> Password: </span></td>
                                                <td>
                                                <input type='password' name='j_password'>
                                                <!--<input id="Passwd" class="gaia le val" type="password" size="18" name="Passwd"/></td>-->
                                            </tr>
                                            <tr>
                                                <td/>
                                            <td align="left"/></tr>
                                            <tr>
                                                <td valign="top" align="right">
                                                    <input id="PersistentCookie" type="checkbox" value="yes" name="PersistentCookie"/>
                                                <input type="hidden" value="1" name="rmShown"/></td>
                                                <td>
                                                <span class="gaia le rem"> Remember me on this computer. </span></td>
                                            </tr>
                                            <tr>
                                                <td  valign="top" align="right">
                                                    <input type="submit" value="Sign In" name="singIn" />
                                                </td>  
                                            </tr>
                                            <tr>
                                                <td/>
                                                <td align="left"></td>
                                            </tr>
                                            <tr id="ga-fprow">
                                                <td class="gaia le fpwd" valign="bottom" nowrap="nowrap" height="70" align="center" colspan="2">
                                                <a target="_top" href="                "> I cannot access my account </a></td>
                                            </tr>
                                            <tr id="ga-fprow">
                                                <td class="gaia le fpwd" valign="bottom" nowrap="nowrap" height="70" align="center" colspan="2">
                                                <a target="_top" href="                "> Create a new account </a></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </form>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        
    </body>
</html>
