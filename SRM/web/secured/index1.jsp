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
            dojo.require("dijit.layout.ContentPane");
            dojo.require("dijit.layout.LayoutContainer");
            dojo.require("dijit.form.CheckBox");
            dojo.require("dijit.form.DateTextBox");
        </script>
    </head>
    <body class="tundra">
        
        <div dojoType="dijit.layout.LayoutContainer" style="width: 100%; height: 100%; padding: 0; margin: 0; border: 0;">
            
            <div dojoType="dijit.layout.ContentPane" layoutAlign="top" >
                
            </div>
            <div dojoType="dijit.layout.ContentPane" layoutAlign="left"
                 style="background-color:lightblue;width: 50%;">
                
            </div>
            <div dojoType="dijit.layout.ContentPane" layoutAlign="client">
                <table>
                    <tr>
                        <td>
                            <label for="name"></label>
                        </td>
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
                        </td>
                        <td>
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
                     
                    
                    callEventService(startDateString , startDateString );                  
                    }
                    
                    function weekEventsButtonClicked() {
                    var startDate = new Date(); 
                    var yr1 = (startDate.getFullYear().toString().substr(2,2));
                    var endDate=new Date()
                    var yr2 = (endDate.getFullYear().toString().substr(2,2));
                    endDate.setDate(endDate.getDate()+7)                    
                    var startDateString = startDate.getMonth()+1 + '/' + startDate.getDate() + '/' + yr1;                    
                    var endDateString = endDate.getMonth() +1 + '/' + endDate.getDate() + '/' + yr2;                    
                    
                    callEventService(startDateString , endDateString );                    
                    }
                    
                    function displayEventsButtonClicked() {
                    
                    var startDateString = $("eventStartDateButton").value ;
                    var endDateString = $("eventEndDateButton").value;
                    callEventService(startDateString , endDateString );                    
                    
                    
                    }
                    
                    function callEventService(startDate, endDate) {    
                    startDate = '"'+ startDate + '"';
                    endDate = '"'+ endDate + '"';                        
                    eventRemoteService.getEvents(objectEval(startDate), 
                    objectEval(endDate), reply0);
                    }
                    var reply0 = function(data)
                    {
                    var x = data;
                    alert(data);                    
                    if (data != null && typeof data == 'object') alert(dwr.util.toDescriptiveString(data, 2));
                    else dwr.util.setValue('d0', dwr.util.toDescriptiveString(data, 1));
                    }
                </script>
                <span id='d0' class='reply'></span>
                <table id="eventTable" border='2'>		
                </table>
            </div>
        </div>       
        
    </body>
</html>
