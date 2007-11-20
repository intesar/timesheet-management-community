<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
        <style type="text/css">
            @import "http://o.aolcdn.com/dojo/1.0.0/dijit/themes/tundra/tundra.css";
            @import "http://o.aolcdn.com/dojo/1.0.0/dojo/resources/dojo.css"
        </style>
        <script type="text/javascript" src="http://o.aolcdn.com/dojo/1.0.0/dojo/dojo.xd.js"
                djConfig="parseOnLoad: true"></script>
        <script type="text/javascript">
            dojo.require("dojo.parser");
            dojo.require("dijit.form.TextBox");
            dojo.require("dijit.form.ValidationTextBox");
        </script>
    </head>
    <body class="tundra">
        <html:link href="createEvent.do" >New Event </html:link>
        <html:link href="createUniversity.do" >New University</html:link>
        <html:link href="createEmailGroup.do" > New Email Group </html:link>
        <br/>
        <html:form action="searchAction">
            <input type="text" name="searchText" value=""
                   dojoType="dijit.form.TextBox"
                   trim="true"
                   lowercase="true"
                   required="true"
                   promptMessage="Search String"
                   invalidMessage="Empty Text!"
                   />
            <html:submit title="Search" />
        </html:form>
        <br/>
        
        
    </body>
</html>