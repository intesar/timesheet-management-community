<%@ taglib prefix="a" uri="http://jmaki/v1.0/jsp" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="com.abbhsoft.srm.model.*" %>
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
    <body  class="tundra">
        <% 
        University u = (University) request.getAttribute("university");
        %>
        <label for="name"><%= u.getName() %> </label>
        <br/>
        
        <%-- Event information --%>
        <table border="0">
            
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
                        <td><html:text property="type"/></td>
                        <td><html:text property="descript"/></td>
                        <td><input type="text" name="dateString" dojoType="dijit.form.DateTextBox" required="true"/></td>
                        <td><html:radio property="priority" value="high"/>High<html:radio property="priority" value="medium"/>Medium<html:radio property="priority" value="low"/>Low</td>
                        <td><html:submit/></td>
                    </tr>
                </tbody>
            </table>
        </html:form>
        
        
        <%-- Student information --%>
        
        <table border="0">
            
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
                        <td><html:text property="firstName"/></td>
                        <td><html:text property="lastName"/></td>
                        <td><html:text property="email"/></td>
                        <td><html:text property="mobilePhone"/></td>
                        <td><html:submit/></td>
                    </tr>
                </tbody>
            </table>
        </html:form>
        
        
         <%-- Email Groups information --%>
        
        <table border="0">
            
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
                        <td><html:text property="groupEmail"/></td>
                        <td><html:text property="owner"/></td>
                        <td><html:text property="subscribeEmail"/></td>
                        <td><html:text property="unSubscribeEmail"/></td>
                        <td><html:submit/></td>
                    </tr>
                </tbody>
            </table>
        </html:form>
        
        <%-- Campus information --%>
        
        <table border="0">
            
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
                        <td><html:text property="campus"/></td>
                        <td><html:text property="street"/></td>
                        <td><html:text property="city"/></td>
                        <td><html:text property="state"/></td>
                        <td><html:text property="zip"/></td>
                        <td><html:text property="country"/></td>
                        <td><html:submit/></td>
                    </tr>
                </tbody>
            </table>
        </html:form>
        
    </body>
</html>
