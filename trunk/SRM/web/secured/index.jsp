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
        <script type='text/javascript' src='/SRM/dwr/interface/addEntityRemoteService.js'></script>
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
                   size="40"
                   />
            <button dojoType="dijit.form.Button" type="submit"
                    iconClass="mailIconOk">Search</button>
        </html:form>
        <br/>
        
        
        
        <div dojoType="dijit.Dialog" title="New University" id="universityDiv">           
            
            <html:errors/>
            <html:form action="universityAction">
                <table border="0">                        
                    <tbody>
                        <tr>
                            <td><label for="name">University Name: </label></td>
                            <td><input dojoType="dijit.form.TextBox"  name="name" id="univId"
                                           trim="true"
                                           lowercase="true"
                                           required="true"
                                           promptMessage="University Name"
                                       invalidMessage="Cannot be Empty!"/></td>
                        </tr>
                        <tr>
                        
                        <tr>
                            <td>
                                <button class='ibutton' type='button' dojoType="dijit.form.Button" onclick='callService();' value='Execute'  title='Calls addEntityRemoteService.addUniversity(). View source for details.'
                                        >Add University </button>
                                <script type='text/javascript'>
                                    function callService() {
                                    var universityName = '"'+ $("univId").value + '"';
                                    addEntityRemoteService.addUniversity(objectEval(universityName), reply0);
                                    }
                                    var reply0 = function(data)
                                    {
                                    if (data != null && typeof data == 'object') alert(dwr.util.toDescriptiveString(data, 2));
                                    else dwr.util.setValue('d0', dwr.util.toDescriptiveString(data, 1));
                                    }
                                </script>
                            </td>
                            <td>
                            <span id='d0' class='reply'></span>
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
                                           id="eventType"
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
                                           id="eventDescription"
                                       /></td>
                        </tr>
                        <tr>
                            <td><label for="name">Date: </label></td>
                            <td><input type="text" name="dateString"
                                           dojoType="dijit.form.DateTextBox"
                                           required="true"
                                           promptMessage="Event Date"
                                           invalidMessage="Cannot be Empty!"
                                           id="eventDate"
                                           value="2007-12-30"
                                       /></td>
                        </tr>
                        <tr>
                            <td><label for="name">Priority: </label></td>
                            <td>
                                <input name="priority" id="priorityHigh" value="high" dojoType="dijit.form.RadioButton" checked="checked" type="radio"/>High
                                <input name="priority" id="priorityMedium" value="medium" dojoType="dijit.form.RadioButton"   type="radio"/>Medium
                                <input name="priority" id="priorityLow" value="low" dojoType="dijit.form.RadioButton"   type="radio"/>Low
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <button dojoType="dijit.form.Button" type="reset"
                                        iconClass="mailIconCancel">Abort</button>
                            </td>
                            <td>
                                <button class='ibutton' type='button' dojoType="dijit.form.Button" onclick='callAddEventService();' value='Add Event'  title='Calls addEntityRemoteService.addUniversity(). View source for details.'
                                        >Add Event </button>
                                <script type='text/javascript'>
                                    function callAddEventService() {
                                    var eventType1 = '"'+ $("eventType").value + '"';
                                    var eventDescription1 = '"'+ $("eventDescription").value + '"';
                                    var eventDate1 = '"'+ $("eventDate").value + '"';
                                    var priority1 = null;
                                    if ( $("priorityHigh").checked ) {
                                    priority1 = '"'+'high' + '"'; 
                                    } else if ( $("priorityMedium").checked ) {
                                    priority1 = '"'+'medium' + '"';  
                                    } else  {
                                    priority1 = '"'+'low' + '"';  
                                    } 
                                    
                                    
                                    addEntityRemoteService.addEvent(objectEval(eventType1), objectEval(eventDescription1), objectEval(eventDate1), objectEval(priority1), reply1);
                                    
                                    }
                                    var reply1 = function(data)
                                    {
                                    if (data != null && typeof data == 'object') alert(dwr.util.toDescriptiveString(data, 2));
                                    else dwr.util.setValue('d1', dwr.util.toDescriptiveString(data, 1));
                                    }
                                </script>
                                <span id='d1' class='reply'></span>
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