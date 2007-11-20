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
            @import "http://o.aolcdn.com/dojo/1.0.0/dojo/resources/dojo.css";
        </style>
        
        <script type="text/javascript" src="http://o.aolcdn.com/dojo/1.0.0/dojo/dojo.xd.js"
                djConfig="parseOnLoad: true"></script>
        
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
        </script>
    </head>
    <body class="tundra">
        
        
        
        
        <br/>
        
        
        
        
        <div id="toolbar1" dojoType="dijit.Toolbar"
             ><div dojoType="dijit.form.Button" id="toolbar1.cut" iconClass="dijitEditorIcon"   
                  onclick="dijit.byId('universityDiv').show()">New University</div
            ><div dojoType="dijit.form.Button" id="toolbar1.copy" iconClass="dijitEditorIcon "
                  onclick="dijit.byId('studentDiv').show()">New Student</div
            ><div dojoType="dijit.form.Button" id="toolbar1.paste" iconClass="dijitEditorIcon "
                  onclick="dijit.byId('eventDiv').show()">New Event</div
            ><!-- The following adds a line between toolbar sections
            -->
            <div dojoType="dijit.form.ToggleButton" id="toolbar1.bold"
                 iconClass="dijitEditorIcon " 
                 onclick="dijit.byId('emailGroupDiv').show()">New Email Group</div>
        </div>
        
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
        
        
        
        <div dojoType="dijit.Dialog" title="New University" id="universityDiv">           
            
            <html:errors/>
            <html:form action="universityAction">
                <table border="0">                        
                    <tbody>
                        <tr>
                            <td><label for="name">University Name: </label></td>
                            <td><input dojoType="dijit.form.TextBox"  name="name"
                                           trim="true"
                                           lowercase="true"
                                           required="true"
                                           promptMessage="University Name"
                                       invalidMessage="Cannot be Empty!"/></td>
                        </tr>
                        <tr>
                            <td>
                                <button dojoType="dijit.form.Button" type="reset"
                                        iconClass="mailIconCancel">Abort</button>
                            </td>
                            <td>
                                <button dojoType="dijit.form.Button" type="submit"
                                        iconClass="mailIconOk">OK</button>
                            </td>                              
                        </tr>
                    </tbody>
                </table>
            </html:form>          
            
        </div>
        
        <div dojoType="dijit.Dialog" title="New Student" id="studentDiv">     
        </div>
        
        <div dojoType="dijit.Dialog" title="New Event" id="eventDiv">   
            <html:errors/>
            <html:form action="eventAction">
                <table border="0">
                    
                    <tbody>
                        <tr>
                            <td><label for="name">Type: </label></td>
                            <td><input name="type" type="text"
                                           dojoType="dijit.form.TextBox"
                                           trim="true"
                                           lowercase="true"
                                           required="true"
                                           promptMessage="Event Name"
                                           invalidMessage="Cannot be Empty!"
                                       /></td>
                        </tr>
                        <tr>
                            <td><label for="name">Description: </label></td>
                            <td><input name="descript" type="text"
                                           dojoType="dijit.form.TextBox"
                                           trim="true"
                                           lowercase="true"
                                           required="false"
                                           promptMessage="Description Name"
                                           invalidMessage="Cannot be Empty!"
                                       /></td>
                        </tr>
                        <tr>
                            <td><label for="name">Date: </label></td>
                            <td><input type="text" name="dateString"
                                           dojoType="dijit.form.DateTextBox"
                                           required="true"
                                           promptMessage="Event Date"
                                           invalidMessage="Cannot be Empty!"
                                       /></td>
                        </tr>
                        <tr>
                            <td><label for="name">Priority: </label></td>
                            <td>
                                <input name="priority" value="high" dojoType="dijit.form.RadioButton" checked="checked" type="radio"/>High
                                <input name="priority" value="medium" dojoType="dijit.form.RadioButton"   type="radio"/>Medium
                                <input name="priority" value="low" dojoType="dijit.form.RadioButton"   type="radio"/>Low
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <button dojoType="dijit.form.Button" type="reset"
                                        iconClass="mailIconCancel">Abort</button>
                            </td>
                            <td>
                                <button dojoType="dijit.form.Button" type="submit"
                                        iconClass="mailIconOk">OK</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
                
            </html:form>            
        </div>
        
        <div dojoType="dijit.Dialog" title="New Email Group" id="emailGroupDiv">  
            <html:errors/>
            <html:form action="/groupAction">
                <table>
                    <tr>
                        <td> Owner : </td>
                        <td> <input type="text" name="owner" 
                                        dojoType="dijit.form.TextBox"
                                        trim="true"
                                        lowercase="true"
                                        required="false"
                                        promptMessage="Owner Email"
                                        invalidMessage="Cannot be Empty!"
                                    /></td>
                    </tr>
                    <tr>
                        <td> Subcribe email : </td>
                        <td> <input type="text" name="subscribeEmail" 
                                        dojoType="dijit.form.TextBox"
                                        trim="true"
                                        lowercase="true"
                                        required="false"
                                        promptMessage="Email"
                                        invalidMessage="Cannot be Empty!"
                                    /> </td>
                    </tr>
                    <tr>
                        <td> Group email : </td>
                        <td> <input type="text" name="groupEmail" dojoType="dijit.form.TextBox"
                                        trim="true"
                                        lowercase="true"
                                        required="true"
                                        promptMessage="Email"
                                        invalidMessage="Cannot be Empty!"
                                    /></td>
                    </tr>
                    <tr>
                        <td> Unsubscribe email : </td>
                        <td> <input type="text" name="unSubscribeEmail"dojoType="dijit.form.TextBox"
                                        trim="true"
                                        lowercase="true"
                                        required="false"
                                        promptMessage="Email"
                                        invalidMessage="Cannot be Empty!"
                                    /></td>
                    </tr>
                    <tr>
                        <td>
                            <button dojoType="dijit.form.Button" type="reset"
                                    iconClass="mailIconCancel">Abort</button>
                        </td>
                        <td>
                            <button dojoType="dijit.form.Button" type="submit"
                                    iconClass="mailIconOk">OK</button>
                        </td>
                    </tr>
                </table>
            </html:form>            
        </div>
        
        
        <br/>
    </body>
</html>