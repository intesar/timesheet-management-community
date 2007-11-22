<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html>
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
    
            dojo.require("dijit.layout.ContentPane");
            dojo.require("dijit.layout.LayoutContainer");
    
    
        </script>
    </head>
    <body class="tundra">
        
        <div dojoType="dijit.layout.LayoutContainer" style="width: 100%; height: 100%; padding: 0; margin: 0; border: 0;">
            
            <div dojoType="dijit.layout.ContentPane" layoutAlign="top" >
                 
        <div id="toolbar1" dojoType="dijit.Toolbar"
        ><div dojoType="dijit.form.Button" id="toolbar1.university" iconClass="dijitEditorIcon"   
                  onclick="dijit.byId('universityDiv').show()">New University</div
            ><div dojoType="dijit.form.Button" id="toolbar1.student" iconClass="dijitEditorIcon "
                  onclick="dijit.byId('studentDiv').show()">New Student</div
            ><div dojoType="dijit.form.Button" id="toolbar1.event" iconClass="dijitEditorIcon "
                  onclick="dijit.byId('eventDiv').show()">New Event</div
            ><!-- The following adds a line between toolbar sections
            -->
            <div dojoType="dijit.form.ToggleButton" id="toolbar1.emailGroup"
                 iconClass="dijitEditorIcon " 
                 onclick="dijit.byId('emailGroupDiv').show()">New Email Group</div>
            <div dojoType="dijit.form.ToggleButton" id="toolbar1.developer"
                 iconClass="dijitEditorIcon " 
                 onclick="dijit.byId('developersDiv').show()">Developers</div>
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
        
        
        <!-- Add University -->
        
        
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
                        
                        <span id='d0' class='reply'></span>
                    </tr>
                </tbody>
            </table>
            </html:form>          
            
        </div>
        
        <!-- End of Add University -->
       
        
        <!-- Add Student -->
        
        <div  dojoType="dijit.Dialog" title="New Student" id="studentDiv">    
            
            <table>
                
                <tr>
                    <td>
                        <table border="0">                        
                            <tbody>
                                
                                
                                
                                <table>
                                
                                <h1> Name </h1>
                                
                                <tr>
                                    <td><label for="name">First Name: </label></td>
                                    <td><input dojoType="dijit.form.TextBox"  name="firstName" id="firstName"
                                                   trim="true"
                                                   lowercase="true"
                                                   required="true"
                                                   promptMessage="First Name"
                                               invalidMessage="Cannot be Empty!"/></td>
                                </tr>
                                <tr>
                                    <td><label for="name">Last Name: </label></td>
                                    <td><input dojoType="dijit.form.TextBox"  name="lastName" id="lastName"
                                                   trim="true"
                                                   lowercase="true"
                                                   required="true"
                                                   promptMessage="First Name"
                                               invalidMessage="Cannot be Empty!"/></td>
                                </tr>
                                
                                
                                <tr>
                                    <td><label for="name"> Middle Name: </label></td>
                                    <td><input dojoType="dijit.form.TextBox"  name="middleName" id="mi"
                                                   trim="true"
                                                   lowercase="true"
                                                   required="true"
                                                   promptMessage="Middle Name"
                                               invalidMessage="Cannot be Empty!"/></td>
                                </tr>
                                
                                
                                </table>
                                
                                <table>
                                    <h1> Contact Information </h1>
                                    
                                <tr>
                                    <td><label for="name">Email: </label></td>
                                    <td><input dojoType="dijit.form.TextBox"  name="email" id="email"
                                                   trim="true"
                                                   lowercase="true"
                                                   required="true"
                                                   promptMessage="Email"
                                               invalidMessage="Cannot be Empty!"/></td>
                                </tr>
                                
                                <tr>
                                    <td><label for="name">See Email: </label></td>
                                    <td><input dojoType="dijit.form.TextBox"  name="seeEame" id="secondaryEmail"
                                                   trim="true"
                                                   lowercase="true"
                                                   required="true"
                                                   promptMessage="See Email"
                                               invalidMessage="Cannot be Empty!"/></td>
                                </tr>
                                
                                <tr>
                                    <td><label for="name">Mobile Phone: </label></td>
                                    <td><input dojoType="dijit.form.TextBox"  name="mobilePhone" id="mobilePhone"
                                                   trim="true"
                                                   lowercase="true"
                                                   required="true"
                                                   promptMessage="Mobile Phone"
                                               invalidMessage="Cannot be Empty!"/></td>
                                </tr>
                                <tr>
                                    <td><label for="name">Home Phone: </label></td>
                                    <td><input dojoType="dijit.form.TextBox"  name="homePhone" id="homePhone"
                                                   trim="true"
                                                   lowercase="true"
                                                   required="true"
                                                   promptMessage="Home Phone"
                                               invalidMessage="Cannot be Empty!"/></td>
                                </tr>
                                
                                <tr>
                                    <td><label for="name">Other Contact: </label></td>
                                    <td><input dojoType="dijit.form.TextBox"  name="otherContact" id="otherPhone"
                                                   trim="true"
                                                   lowercase="true"
                                                   required="true"
                                                   promptMessage="Other Contact"
                                               invalidMessage="Cannot be Empty!"/></td>
                                </tr>
                                
                                <tr>
                                    <td><label for="name">Fax: </label></td>
                                    <td><input dojoType="dijit.form.TextBox"  name="fax" id="fax"
                                                   trim="true"
                                                   lowercase="true"
                                                   required="true"
                                                   promptMessage="Fax"
                                               invalidMessage="Cannot be Empty!"/></td>
                                </tr>
                                
                                </table>
                                
                                <table>
                                
                                <h1> Other Information </h1>
                                
                                <tr>
                                    <td><label for="name">Education: </label></td>
                                    <td><input dojoType="dijit.form.TextBox"  name="education" id="education"
                                                   trim="true"
                                                   lowercase="true"
                                                   required="true"
                                                   promptMessage="Education"
                                               invalidMessage="Cannot be Empty!"/></td>
                                </tr>
                                
                                <tr>
                                    <td><label for="name">Gender: </label></td>
                                    <td><input dojoType="dijit.form.TextBox"  name="gender" id="gender"
                                                   trim="true"
                                                   lowercase="true"
                                                   required="true"
                                                   promptMessage="Gender"
                                               invalidMessage="Cannot be Empty!"/></td>
                                </tr>
                                
                                <tr>
                                    <td><label for="name">Nationality: </label></td>
                                    <td><input dojoType="dijit.form.TextBox"  name="nationality" id="nationality"
                                                   trim="true"
                                                   lowercase="true"
                                                   required="true"
                                                   promptMessage="Nationility"
                                               invalidMessage="Cannot be Empty!"/></td>
                                </tr>
                                
                                <tr>
                                    <td><label for="name">Status: </label></td>
                                    <td><input dojoType="dijit.form.TextBox"  name="status" id="status"
                                                   trim="true"
                                                   lowercase="true"
                                                   required="true"
                                                   promptMessage="Status"
                                               invalidMessage="Cannot be Empty!"/></td>
                                </tr>
                                
                                <tr>
                                    <td><label for="name">Type: </label></td>
                                    <td><input dojoType="dijit.form.TextBox"  name="type" id="type"
                                                   trim="true"
                                                   lowercase="true"
                                                   required="true"
                                                   promptMessage="Type"
                                               invalidMessage="Cannot be Empty!"/></td>
                                </tr>
                                
                                <tr>
                                    <td><label for="name">Expected Start Date: </label></td>
                                    <td><input dojoType="dijit.form.TextBox"  name="expectedStartDate" id="expectedStartDate"
                                                   trim="true"
                                                   lowercase="true"
                                                   required="true"
                                                   promptMessage="Expected Start Date"
                                               invalidMessage="Cannot be Empty!"/></td>
                                </tr>
                                
                                <tr>
                                    <td><label for="name">Reffered By: </label></td>
                                    <td><input dojoType="dijit.form.TextBox"  name="refferedBy" id="refferedBy"
                                                   trim="true"
                                                   lowercase="true"
                                                   required="true"
                                                   promptMessage="Reffered By"
                                               invalidMessage="Cannot be Empty!"/></td>
                                </tr>
                                
                                </table>        
                                <tr>
                                    <td>
                                        <button class='ibutton' type='button' dojoType="dijit.form.Button" onclick='callService();' value='Execute'  title='Calls addEntityRemoteService.addUniversity(). View source for details.'
                                        >Add Student </button>
                                    </td>
                                </tr>             
                            </tbody>
                        </table>
                    </td>
                    <td>
                        
                        
                        <table>
                            <h1> ADDRESS </h1>
                            <tr>
                                
                                
                                <td>Street</td>
                                <td><input dojoType="dijit.form.TextBox"  name="type" id="street"
                                                   trim="true"
                                                   lowercase="true"
                                                   required="true"
                                                   promptMessage="Type"
                                               invalidMessage="Cannot be Empty!"/></td>
                            </tr>
                            <tr>
                                <td>City</td>
                                <td><input dojoType="dijit.form.TextBox"  name="type" id="city"
                                                   trim="true"
                                                   lowercase="true"
                                                   required="true"
                                                   promptMessage="Type"
                                               invalidMessage="Cannot be Empty!"/></td>
                            </tr>
                            <tr>
                                <td>State</td>
                                <td><input dojoType="dijit.form.TextBox"  name="type" id="state"
                                                   trim="true"
                                                   lowercase="true"
                                                   required="true"
                                                   promptMessage="Type"
                                               invalidMessage="Cannot be Empty!"/></td>
                            </tr>
                            
                            <tr>
                                <td>Zipcode</td>
                                <td><input dojoType="dijit.form.TextBox"  name="type" id="zipcode"
                                                   trim="true"
                                                   lowercase="true"
                                                   required="true"
                                                   promptMessage="Type"
                                               invalidMessage="Cannot be Empty!"/></td>
                            </tr>
                            
                            
                            <tr>
                                <td>Country</td>
                                <td><input dojoType="dijit.form.TextBox"  name="type" id="country"
                                                   trim="true"
                                                   lowercase="true"
                                                   required="true"
                                                   promptMessage="Type"
                                               invalidMessage="Cannot be Empty!"/></td>
                            </tr>
                            
                            
                            
                        </table>
                    </td>
                </tr>
            </table>
        </div>
        
        
        <!-- End of Add Student -->
        
        <!-- Add Event -->
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
        
        <!-- End of Add Event -->
        
        <!-- Add Email Group -->
        
        
        <div dojoType="dijit.Dialog" title="New Email Group" id="emailGroupDiv">  
            <html:errors/>
            <html:form action="/groupAction">
                <table>
                    <tr>
                        <td> Group email : </td>
                        <td> <input type="text" name="groupEmail" dojoType="dijit.form.TextBox"
                                        trim="true"
                                        lowercase="true"
                                        required="true"
                                        promptMessage="Email"
                                        invalidMessage="Cannot be Empty!"
                                        id="groupEmail"
                        /></td>
                    </tr>
                    <tr>
                        <td> Owner : </td>
                        <td> <input type="text" name="owner" 
                                        dojoType="dijit.form.TextBox"
                                        trim="true"
                                        lowercase="true"
                                        required="false"
                                        promptMessage="Owner Email"
                                        invalidMessage="Cannot be Empty!"
                                        id="owner"
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
                                        id="subscribeEmail"
                        /> </td>
                        
                    </tr>
                    <tr>
                        <td> Unsubscribe email : </td>
                        <td> <input type="text" name="unSubscribeEmail"dojoType="dijit.form.TextBox"
                                        trim="true"
                                        lowercase="true"
                                        required="false"
                                        promptMessage="Email"
                                        invalidMessage="Cannot be Empty!"
                                        id="unSubscribeEmail"
                        /></td>
                    </tr>
                    <tr>
                        <td>
                            <button dojoType="dijit.form.Button" type="reset"
                                    iconClass="mailIconCancel">Abort</button>
                        </td>
                        <td>
                            <button class='ibutton' type='button' dojoType="dijit.form.Button" onclick='callAddEmailGroupService();' value='Add EmailGroup'  title='Calls addEntityRemoteService.addUniversity(). View source for details.'
                            >Add EmailGroup </button>
                            <script type='text/javascript'>
                                function callAddEmailGroupService() {
                                var emailGroup1 = '"'+ $("groupEmail").value + '"';
                                var owner1 = '"'+ $("owner").value + '"';
                                var subscribe1 = '"'+ $("subscribeEmail").value + '"';
                                var unsubscribe1 = '"' + $("unSubscribeEmail").value +'"';                          
                                
                                addEntityRemoteService.addEmailGroup(objectEval(emailGroup1), 
                                objectEval(owner1),
                                objectEval(subscribe1), 
                                objectEval(unsubscribe1), reply1);
                                
                                }
                                var reply1 = function(data)
                                {
                                if (data != null && typeof data == 'object') alert(dwr.util.toDescriptiveString(data, 2));
                                else dwr.util.setValue('d2', dwr.util.toDescriptiveString(data, 1));
                                }
                            </script>
                            <span id='d2' class='reply'></span>
                        </td>
                    </tr>
                </table>
            </html:form>            
        </div>
        
        <!-- End of Email Group -->
        
        <!-- Add Developers -->
        
        
        <div dojoType="dijit.Dialog" title="Developers" id="developersDiv">          
            
            <table border="0">                        
                <thead>
                        <tr>
                            <th>Name</th>                                                       
                            <th>Title</th>
                            <th>Email</th>
                            <th>Contribution</th>                            
                        </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><label for="name"> Saddam Hossain</label></td>                  
                        <td><label for="name"> Java Developer </label></td>                  
                        <td><label for="name"> saddam.hossain@abbhsoft.com</label></td>                  
                        <td><label for="name"> GUI Design and Regression Testing</label></td>                  
                                                     
                    </tr>
                    <tr>
                        <td><label for="name"> Mudarsir Khan </label></td>                  
                        <td><label for="name"> Java Developer</label></td>                  
                        <td><label for="name"> mir.khan@abbhsoft.com</label></td>                  
                        <td><label for="name"> Database Design, Implementation & Code</label></td>                  
                                                     
                    </tr>
                    <tr>
                        <td><label for="name"> </label></td>                  
                        <td><label for="name"> </label></td>                  
                        <td><label for="name"> </label></td>                  
                        <td><label for="name"> </label></td>                  
                                                     
                    </tr>
                    <tr>
                        <td><label for="name"> </label></td>                  
                        <td><label for="name"> </label></td>                  
                        <td><label for="name"> </label></td>                  
                        <td><label for="name"> </label></td>                  
                                                     
                    </tr>
                    
                </tbody>
            </table>
                
            
        </div>
        
        <!-- End of Developers -->
        
            </div>
            <div dojoType="dijit.layout.ContentPane" layoutAlign="left"
                 style="width: 50%;">
                
            </div>
            <div dojoType="dijit.layout.ContentPane" layoutAlign="client">
                <table>
                    <tr>
                        <td>
                            <label for="name"></label>
                        </td>
                        <td>
                            <label for="name">Start Date </label>
                        </td>
                        <td>
                            <label for="name">End Date </label>
                        </td>
                        <td>
                            <label for="name"> </label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input name="priority" id="currentEventsButton" value="high" 
                                   dojoType="dijit.form.RadioButton"  
                                   onclick="currentEventsButtonButtonClicked();" type="radio"/>Current Events
                        <br/>
                            <input name="priority" id="weekEventsButton" value="high" 
                                   dojoType="dijit.form.RadioButton"  type="radio"
                                   onclick="weekEventsButtonClicked();"/>Week Events
                        </td>                        
                        <td>
                            <input type="text" name="dateString"
                                   dojoType="dijit.form.DateTextBox"
                                   required="true"
                                   promptMessage="Event Start Date"
                                   invalidMessage="Cannot be Empty!"
                                   id="eventStartDateButton"
                                   
                                   />
                        </td>
                        <td>
                            <input type="text" name="dateString"
                                   dojoType="dijit.form.DateTextBox"
                                   required="true"
                                   promptMessage="Event End Date"
                                   invalidMessage="Cannot be Empty!"
                                   id="eventEndDateButton"
                                   
                                   />
                        </td>
                        <td>
                            <button dojoType="dijit.form.Button" type="submit"
                                    iconClass="mailIconOk"
                                    onclick="displayEventsButtonClicked();">Display</button>
                        </td>
                    </tr>
                </table>
                <script>
                    
                    function currentEventsButtonButtonClicked() {
                    var startDate = new Date();    
                    var yr = (startDate.getFullYear().toString().substr(2,2));
                    var startDateString = startDate.getMonth()+1 + '/' + startDate.getDate() + '/' + yr ;  
                    fillTable(startDateString , startDateString );                  
                    
                    
                    }
                    
                    function weekEventsButtonClicked() {
                    var startDate = new Date(); 
                    var yr1 = (startDate.getFullYear().toString().substr(2,2));
                    var endDate=new Date()
                    var yr2 = (endDate.getFullYear().toString().substr(2,2));
                    endDate.setDate(endDate.getDate()+7)                    
                    var startDateString = startDate.getMonth()+1 + '/' + startDate.getDate() + '/' + yr1;                    
                    var endDateString = endDate.getMonth() +1 + '/' + endDate.getDate() + '/' + yr2;                    
                    
                    fillTable(startDateString , endDateString );                    
                    }
                    
                    function displayEventsButtonClicked() {
                    
                    var startDateString = $("eventStartDateButton").value ;
                    var endDateString = $("eventEndDateButton").value;
                    fillTable(startDateString , endDateString );                    
                    
                    
                    }
                    
                   
                    
                    var peopleCache = { };
                    var viewed = -1;
                    
                    function fillTable(startDate, endDate) {
                    startDate = '"'+ startDate + '"';
                    endDate = '"'+ endDate + '"'; 
                    eventRemoteService.getEvents(objectEval(startDate), 
                    objectEval(endDate), function(people) {
                    // Delete all the rows except for the "pattern" row
                    var x = people;
                    
                    dwr.util.removeAllRows("peoplebody", { filter:function(tr) {
                    return (tr.id != "pattern");
                    }});
                    
                    // Create a new set cloned from the pattern row
                    var person, id;
                    people.sort(function(p1, p2) { return p1.type.localeCompare(p2.type); });
                    for (var i = 0; i < people.length; i++) {
                    person = people[i];
                    id = person.id;
                    dwr.util.cloneNode("pattern", { idSuffix:id });
                    dwr.util.setValue("tableType" + id, person.type);
                    dwr.util.setValue("tableDescription" + id, person.descript);
                    dwr.util.setValue("tableDate" + id, person.date);
                    dwr.util.setValue("tablePriority" + id, person.priority);
                    //dwr.util.setValue("tableStudent" + id, person.student.email);
                    //dwr.util.setValue("tableUniversity" + id, person.university.name);
                    //dwr.util.setValue("tableGroup" + id, person.group1.groupEmail);
                    //dwr.util.setValue("tableStatus" + id, person.date);
                    $("pattern" + id).style.display = "table-row";
                    peopleCache[id] = person;
                    }
                    });
                    }
                </script>
                
                
                <table border="1" id="eventTable" class="rowed grey">
                    <thead>
                        <tr>
                            <th>Event</th>                           
                            <th>Date</th>
                            <th>Priority</th>
                            <th>Student</th>
                            <th>University</th>
                            <th>Group</th>
                            <th>Status</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody id="peoplebody">
                        <tr id="pattern" style="display:none;">
                            <td>
                                <span id="tableType"></span><br/>
                                <small>  <span id="tableDescription"></span></small>
                            </td>
                            <td><span id="tableDate"></span></td>
                            <td><span id="tablePriority">Medium</span></td>
                            <td><span id="tableStudent"></span></td>
                            <td><span id="tableUniversity"></span></td>
                            <td><span id="tableGroup"></span></td>
                            <td><span id="tableStatus"></span></td>
                            <td>
                                <input id="edit" type="button" value="Done" onclick="editClicked(this.id)"/>
                                <input id="delete" type="button" value="Send Email" onclick="deleteClicked(this.id)"/>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>       
        
    </body>
</html>
