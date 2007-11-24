
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="com.abbhsoft.srm.model.*" %>
<%@page import="com.abbhsoft.srm.service.*" %>
<%@page import="java.util.*" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>University Detail</title>
        <link rel="stylesheet" href="css/jq.css" type="text/css" media="print, projection, screen" />
        <link rel="stylesheet" href="http://tablesorter.com/themes/blue/style.css" type="text/css" media="print, projection, screen" />
        
        <style type="text/css">
            @import "http://o.aolcdn.com/dojo/0.9.0/dijit/themes/tundra/tundra.css";
            @import "http://o.aolcdn.com/dojo/0.9.0/dojo/resources/dojo.css";
        </style>
        <script type="text/javascript" src="http://tablesorter.com/jquery-latest.js"></script> 
        <script type="text/javascript" src="http://tablesorter.com/jquery.tablesorter.pack.js"></script> 
        <script type="text/javascript">
            $(function() {		
            $("#eventTable").tablesorter();	
            $("#studentTable").tablesorter();	
            $("#groupTable").tablesorter();	
            $("#campusTable").tablesorter();	
            });	
        </script>
        <script type="text/javascript" src="http://o.aolcdn.com/dojo/0.9.0/dojo/dojo.xd.js"
                djConfig="parseOnLoad: true"></script>
        <script type="text/javascript">
            dojo.require("dojo.parser");
            dojo.require("dijit.form.Button");
            dojo.require("dijit.Dialog");
            dojo.require("dijit.form.TextBox");
            dojo.require("dijit.form.DateTextBox");
            dojo.require("dijit.form.CheckBox"); 
            dojo.require("dijit.form.ComboBox");
            function checkPw(dialogFields) {
            if (dialogFields.confirmpw != dialogFields.newpw)
            alert("Confirmation password is different.  Password is unchanged.");
            }
        </script>    
    </head>
    <body  class="tundra">
        <h5>
            <html:link href="home.do" > Home </html:link>
        </h5>
        
        <br/>
        <% 
        
        long id = Long.valueOf(session.getAttribute("universityId").toString());
        //University u = (University) request.getAttribute("university");
        UniversityService service = (UniversityService) ServiceFactory.getInstance().getBean("universityServiceImpl");
        University u = service.getUniversityByIdWithDetails(id);
        %>
        <label for="name"><%= u.getName() %> </label>
        <br/>
        
        <%-- Event information --%>
        <table id="eventTable"  class="tablesorter" border="0" cellpadding="0" cellspacing="1">
            <thead> 
                <tr>                      
                    <th>Date</th> 
                    <th>Description</th>
                    <th>Type</th> 
                    <th>Priority</th>                     
                </tr> 
            </thead>
            
            <tbody>
                <%
                Collection<Event> events = u.getEventCollection();
                if (  events != null && events.size() > 0) {
                for ( Event e : events ) {
                %>
                
                <tr>
                    <td><%= e.getDate() %> </td>
                    <td><%= e.getDescript() %></td>
                    <td><%= e.getType() %></td>
                    <td><%= e.getPriority() %></td>
                </tr>
                
                <%
                }
                }
                %>
                
            </tbody>
        </table>
        
        <html:form action="universityEventAction">
            <table border="0">
                
                <tbody>
                    <tr>
                        <td><label for="name">Type: </label></td>
                        <td><label for="name">Description: </label></td>
                        <td><label for="name">Date: </label></td>
                        <td><label for="name">Priority: </label></td>
                        <td><html:hidden property="university" value='<%= u.getId().toString() %>' /></td>
                    </tr>
                    <tr>
                         <td> <select name="type" id="type"
                                            dojoType="dijit.form.ComboBox"
                                            autocomplete="false"
                                            lowercase="true"
                                            value="Call"
                                            >
                                    <option selected="selected">Call</option>
                                    <option >Email</option>
                                    <option >Speak Personally</option>
                                    <option >SMS</option>
                                    <option >Delegate Contact Responsibility</option>
                                    <option > Other </option>
                                    </select>
                                </td>
                        <td><input type="text" name="descript"
                                       dojoType="dijit.form.TextBox"
                                       trim="true"
                                   lowercase="true"/></td>
                        <td><input type="text" name="dateString" dojoType="dijit.form.DateTextBox" required="true"/></td>
                        <td> <input name="priority" id="priorityHigh" value="high" dojoType="dijit.form.RadioButton" checked="checked" type="radio"/>High
                            <input name="priority" id="priorityMedium" value="medium" dojoType="dijit.form.RadioButton"   type="radio"/>Medium
                            <input name="priority" id="priorityLow" value="low" dojoType="dijit.form.RadioButton"   type="radio"/>Low
                        </td>
                        <td> <button dojoType="dijit.form.Button" type="submit"
                                     iconClass="mailIconCancel">Save</button></td>
                    </tr>
                </tbody>
            </table>
        </html:form>
        
        
        <%-- Student information --%>
        
        <table id="studentTable"  class="tablesorter" border="0" cellpadding="0" cellspacing="1">
            <thead> 
                <tr>                      
                    <th>First Name</th> 
                    <th>Last Name</th>
                    <th>Email</th> 
                    <th>Mobile</th>                     
                </tr> 
            </thead>
            
            <tbody>
                <%
                Collection<Student> students = u.getStudentCollection();
                if (  students != null && students.size() > 0) {
                for ( Student s : students ) {
                %>
                
                <tr>
                    <td><%= s.getFirstName() %> </td>
                    <td><%= s.getLastName() %></td>
                    <td><%= s.getEmail() %></td>
                    <td><%= s.getMobilePhone() %></td>
                </tr>
                
                <%
                }
                }
                %>
                
            </tbody>
        </table>
        
        <html:form action="universityStudentAction">
            <table border="0">
                
                <tbody>
                    <tr>
                        <td><label for="name">First Name: </label></td>
                        <td><label for="name">Last Name: </label></td>
                        <td><label for="name">Email: </label></td>
                        <td><label for="name">Mobile: </label></td>
                        <td><html:hidden property="university" value='<%= u.getId().toString() %>' /></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="firstName"
                                       dojoType="dijit.form.TextBox"
                                       trim="true"
                                   lowercase="true"/></td>
                        <td><input type="text" name="lastName"
                                       dojoType="dijit.form.TextBox"
                                       trim="true"
                                   lowercase="true"/></td>
                        <td><input type="text" name="email"
                                       dojoType="dijit.form.TextBox"
                                       trim="true"
                                   lowercase="true"/></td>
                        <td><input type="text" name="mobilePhone"
                                       dojoType="dijit.form.TextBox"
                                       trim="true"
                                   lowercase="true"/></td>
                        <td> <button dojoType="dijit.form.Button" type="submit"
                                     iconClass="mailIconCancel">Save</button></td>
                    </tr>
                </tbody>
            </table>
        </html:form>
        
        
        <%-- Email Groups information --%>
        
        <table id="groupTable"  class="tablesorter" border="0" cellpadding="0" cellspacing="1">
            <thead> 
                <tr>                      
                    <th>Group Email</th> 
                    <th>Group Owner Email</th>
                    <th>Subscription Email</th> 
                    <th>UnSubscription Email</th>                     
                </tr> 
            </thead>
            
            <tbody>
                <%
                Collection<EmailGroup> emailGroups = u.getGroup1Collection();
                if ( emailGroups != null && emailGroups.size() > 0) {
                for ( EmailGroup eg : emailGroups ) {
                %>
                
                <tr>
                    <td><%= eg.getGroupEmail() %> </td>
                    <td><%= eg.getOwner() %></td>
                    <td><%= eg.getSubscribeEmail() %></td>
                    <td><%= eg.getUnsubscribeEmail() %></td>
                </tr>
                
                <%
                }
                }
                %>
                
            </tbody>
        </table>
        
        <html:form action="universityEmailGroupAction">
            <table border="0">
                
                <tbody>
                    <tr>
                        <td><label for="name">Email Group: </label></td>
                        <td><label for="name">Owner: </label></td>
                        <td><label for="name">Subscribe: </label></td>
                        <td><label for="name">UnSubscribe: </label></td>
                        <td><html:hidden property="university" value='<%= u.getId().toString() %>' /></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="groupEmail"
                                       dojoType="dijit.form.TextBox"
                                       trim="true"
                                   lowercase="true"/></td>
                        <td><input type="text" name="owner"
                                       dojoType="dijit.form.TextBox"
                                       trim="true"
                                   lowercase="true"/></td>
                        <td><input type="text" name="subscribeEmail"
                                       dojoType="dijit.form.TextBox"
                                       trim="true"
                                   lowercase="true"/></td>
                        <td><input type="text" name="unSubscribeEmail"
                                       dojoType="dijit.form.TextBox"
                                       trim="true"
                                   lowercase="true"/></td>
                        <td> <button dojoType="dijit.form.Button" type="submit"
                                     iconClass="mailIconCancel">Save</button></td>
                    </tr>
                </tbody>
            </table>
        </html:form>
        
        <%-- Campus information --%>
        
        <table id="campusTable"  class="tablesorter" border="0" cellpadding="0" cellspacing="1">
            <thead> 
                <tr>                      
                    <th>Campus Name</th> 
                    <th>Street</th>
                    <th>City</th> 
                    <th>State</th>     
                    <th>Zipcode</th>
                    <th>Country</th>
                </tr> 
            </thead>
            
            <tbody>
                <%
                Collection<Campus> campuses = u.getCampusCollection();
                if ( campuses != null && campuses.size() > 0) {
                for ( Campus c : campuses ) {
                %>
                
                <tr>
                    <td><%= c.getName() %> </td>
                    <td><%= c.getAddress().getStreet() %></td>
                    <td><%= c.getAddress().getCity() %></td>
                    <td><%= c.getAddress().getState() %></td>
                    <td><%= c.getAddress().getZipcode() %></td>
                    <td><%= c.getAddress().getCountry() %></td>
                </tr>
                
                <%
                }
                }
                %>
                
            </tbody>
        </table>
        
        <html:form action="universityCampusAction">
            <table border="0">
                
                <tbody>
                    <tr>
                        <td><label for="name">Campus: </label></td>
                        <td><label for="name">Street: </label></td>
                        <td><label for="name">City: </label></td>
                        <td><label for="name">State: </label></td>
                        <td><label for="name">Zipcode: </label></td>
                        <td><label for="name">Country: </label></td>
                        <td><html:hidden property="university" value='<%= u.getId().toString() %>' /></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="campus"
                                       dojoType="dijit.form.TextBox"
                                       trim="true"
                                       value="main"
                                   lowercase="true"/></td>
                        <td><input type="text" name="street"
                                       dojoType="dijit.form.TextBox"
                                       trim="true"
                                   lowercase="true"/></td>
                        <td><input type="text" name="city"
                                       dojoType="dijit.form.TextBox"
                                       trim="true"
                                   lowercase="true"/></td>
                        <td><input type="text" name="state"
                                       dojoType="dijit.form.TextBox"
                                       trim="true"
                                   lowercase="true"/></td>
                        <td><input type="text" name="zip"
                                       dojoType="dijit.form.TextBox"
                                       trim="true"
                                   lowercase="true"/></td>
                        <td><input type="text" name="country"
                                       dojoType="dijit.form.TextBox"
                                       trim="true"
                                   lowercase="true"/></td>
                        <td> <button dojoType="dijit.form.Button" type="submit"
                                     iconClass="mailIconCancel">Save</button></td>
                    </tr>
                </tbody>
            </table>
        </html:form>
        
    </body>
</html>
