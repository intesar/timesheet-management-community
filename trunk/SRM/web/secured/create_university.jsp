<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head><title>New Event</title>
        <style type="text/css">
            @import "http://o.aolcdn.com/dojo/0.9.0/dijit/themes/tundra/tundra.css";
            @import "http://o.aolcdn.com/dojo/0.9.0/dojo/resources/dojo.css"
        </style>
        <script type="text/javascript" src="http://o.aolcdn.com/dojo/0.9.0/dojo/dojo.xd.js"
                djConfig="parseOnLoad: true"></script>
        <script type="text/javascript">
            dojo.require("dojo.parser");
            dojo.require("dijit.form.Button");
            dojo.require("dijit.Dialog");
            dojo.require("dijit.form.TextBox");
            dojo.require("dijit.form.DateTextBox");
            function checkPw(dialogFields) {
            if (dialogFields.confirmpw != dialogFields.newpw)
            alert("Confirmation password is different.  Password is unchanged.");
            }
        </script>    
    </head>
    <body class="tundra">
        <a href="home.do">Home</a>
        <html:errors/>
        <html:form action="universityAction">
            <table border="0">
                
                <tbody>
                    <tr>
                        <td><label for="name">Name: </label></td>
                        <td><html:text property="name"/></td>
                    </tr>
                    <tr>
                        <td><html:reset/></td>
                        <td><html:submit/></td>
                    </tr>
                </tbody>
            </table>
            
        </html:form>
        
    </body>
</html>
