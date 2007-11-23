
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Login</title>
</head>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Layout Container Demo 2</title>
    <style type="text/css">
        @import "http://o.aolcdn.com/dojo/1.0.0/dijit/themes/tundra/tundra.css";
        @import "http://o.aolcdn.com/dojo/1.0.0/dojo/resources/dojo.css";
    </style>
    <script type="text/javascript" src="http://o.aolcdn.com/dojo/1.0.0/dojo/dojo.xd.js"
            djConfig="parseOnLoad: true"></script>
    <style> 
        /* NOTE: for a full screen layout, must set body size equal to the viewport. */
        html, body { height: 100%; width: 100%; margin: 0; padding: 0; }
    </style>
    
    <script type="text/javascript" src="http://o.aolcdn.com/dojo/1.0.0/dojo/dojo.xd.js"
            djConfig="parseOnLoad: true"></script>
    <script type='text/javascript' src='/SRM/dwr/interface/addEntityRemoteService.js'></script>
    <script type='text/javascript' src='/SRM/dwr/interface/eventRemoteService.js'></script>
    <script type='text/javascript' src='/SRM/dwr/engine.js'></script>
    <script type='text/javascript' src='/SRM/dwr/util.js'></script>
    <script type='text/javascript'>
        function objectEval(text)
        {
        // eval() breaks when we use it to get an object using the { a:42, b:'x' }
        // syntax because it thinks that { and } surround a block and not an object
        // So we wrap it in an array and extract the first element to get around
        // this.
        // This code is only needed for interpreting the parameter input fields,
        // so you can ignore this for normal use.
        // The regex = [start of line][whitespace]{[stuff]}[whitespace][end of line]
        text = text.replace(/\n/g, ' ');
        text = text.replace(/\r/g, ' ');
        if (text.match(/^\s*\{.*\}\s*$/))
        {
        text = '[' + text + '][0]';
        }
        return eval(text);
        }
        
        
    </script>
    <script type="text/javascript">
        dojo.require("dojo.parser");
        dojo.require("dijit.form.TextBox");
        dojo.require("dijit.form.ValidationTextBox");
        dojo.require("dijit.Dialog");
        dojo.require("dojo.parser");
        dojo.require("dijit.form.Button");
        dojo.require("dijit.Toolbar");     
        dojo.require("dijit.form.DateTextBox");                 
        dojo.require("dijit.form.CheckBox");            
        dojo.require("dijit.form.ComboBox");
        dojo.require("dijit.layout.ContentPane");
        dojo.require("dijit.layout.LayoutContainer");
    </script>
    
    
</head>
<body class="tundra" onload="">




<button onclick="dijit.byId('loginDiv').show()" class='ibutton'  
        dojoType="dijit.form.Button">If you don't see the Login Screen please click here!</button>

<div dojoType="dijit.Dialog"  title="New University" id="loginDiv">           

<form action="j_acegi_security_check" method="POST">
<table>


<tr>
    <td>User:</td>
    <td><input type='text' name='j_username' value='admin'
                   dojoType="dijit.form.TextBox" id="j_username"
                   trim="true"
                   propercase="true"
                   required="true"
                   promptMessage="Login Name"
               invalidMessage="Cannot be Empty!"></td>
</tr>
<tr>
    <td>Password:</td>
    <td><input type='password' name='j_password' value='Abbh123'
               dojoType="dijit.form.TextBox" id="j_password"
                   trim="true"
                   propercase="true"
                   required="true"
                   promptMessage="Login Name"
               invalidMessage="Cannot be Empty!"></td>
</tr>

<tr>
    <td>
    <button name="reset" type="reset" class='ibutton'  dojoType="dijit.form.Button">Clear</button></td>
    </td>
    <td><button name="submit" type="submit" 
               class='ibutton'  dojoType="dijit.form.Button">Sign In</button></td>
</tr>
</table>
</div>
</div>
</form>

</div>



</body>
</html>
