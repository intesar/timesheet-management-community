<%-- 
Document   : UserDetail
Created on : Nov 18, 2007, 4:17:01 PM
Author     : Sadd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.abbhsoft.srm.model.*"%>
<%@page import="java.util.*"%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
    </head>
    
    <body  class="tundra">
        <% 
        Student s = (Student) request.getAttribute("student");
        %>
        
        <table>
            <tr>
                <td>
                    
                    
                    <table>
                        <tr>    
                            <td> <label for="">First Name </label> </td>
                            <td> <label for=""> <b><%= s.getFirstName() %></b></label> </td>
                            <td> <label for="">Last Name </label> </td>
                            <td> <label for=""> <b><%= s.getLastName() %></b></label> </td>                
                        </tr>
                        <tr>    
                            <td> <label for=""> Email</label> </td>
                            <td> <label for=""> <b><%= s.getEmail() %></b></label> </td>
                            <td> <label for=""> Secondary Email </label> </td>
                            <td> <label for=""> <b><%= s.getSecondaryEmail() %></b></label> </td>                
                        </tr>
                        <tr>    
                            <td> <label for=""> Mobile </label> </td>
                            <td> <label for=""> <b><%= s.getMobilePhone() %></b></label> </td>
                            <td> <label for=""> Home Phone </label> </td>
                            <td> <label for=""> <b><%= s.getHomePhone() %></b></label> </td>                
                        </tr>
                        <tr>    
                            <td> <label for=""> Fax</label> </td>
                            <td> <label for=""><b><%= s.getFax() %> </b></label> </td>
                            <td> <label for=""> Other Phone </label> </td>
                            <td> <label for=""> <b><%= s.getOtherPhone() %></b></label> </td>                
                        </tr>
                    </table>
                </td>
                <td>
                    <table>
                        <tr>    
                            <td> <label for=""> Education </label> </td>
                            <td> <label for=""> <b><%= s.getEducation() %></b></label> </td>
                            <td> <label for=""> Visa Status</label> </td>
                            <td> <label for=""> <b><%= s.getVisaStatus() %></b></label> </td>                
                        </tr>
                        <tr>    
                            <td> <label for=""> Gender </label> </td>
                            <td> <label for=""> <b><%= s.getGender() %></b></label> </td>
                            <td> <label for=""> Age </label> </td>
                            <td> <label for=""><b><%= s.getAge() %> </b></label> </td>                
                        </tr>
                        <tr>    
                            <td> <label for=""> Nationality </label> </td>
                            <td> <label for=""> <b><%= s.getNationality() %></b></label> </td>
                            <td> <label for=""> Reffered By</label> </td>
                            <td> <label for=""> <b><%= s.getRefferedBy() %></b></label> </td>                
                        </tr>
                        <tr>    
                            <td> <label for=""> Expected Start Date</label> </td>
                            <td> <label for=""><b><%= s.getExpectedStartDate() %></b> </label> </td>
                            <td> <label for=""> Tag </label> </td>
                            <td> <label for=""> <b>Cold</b> </label> </td>                
                        </tr>            
                        
                    </table>
                </td>
            </tr>
        </table>
        
        <b> Address </b>
        
        <% 
        if ( s.getAddress() != null ) {
        %>
        
        <table>
            <tr>
                <td><%= s.getAddress().getStreet() %></td>
                <td><%= s.getAddress().getCity() %></td>
                <td><%= s.getAddress().getState() %></td>
                <td><%= s.getAddress().getZipcode() %></td>
                <td><%= s.getAddress().getCountry() %></td>
            </tr>
        </table> 
        <% } %>
        
        <%-- Event information --%>
        <table border="0">
            
            <tbody>
                <%
                Collection<Event> events = s.getEventCollection();
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
        
        <html:form action="studentEventAction">
            <table border="0">
                
                <tbody>
                    <tr>
                        <td><label for="name">Type: </label></td>
                        <td><label for="name">Description: </label></td>
                        <td><label for="name">Date: </label></td>
                        <td><label for="name">Priority: </label></td>
                        <td><html:hidden property="student" value='<%= s.getId().toString() %>' /></td>
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
        
         <%-- Event information --%>
        <table border="0">
            
            <tbody>
                <%
                Collection<Query> queries = s.getQueryCollection();
                if (  queries != null && queries.size() > 0) {
                for ( Query q : queries ) {
                %>
                
                <tr>
                    <td><%= q.getMsg() %> </td>                    
                </tr>
                
                <%
                }
                }
                %>
                
            </tbody>
        </table>
        
        <html:form action="studentQueryAction">
            <table border="0">
                
                <tbody>
                    <tr>
                        <td><label for="name">Query: </label></td>
                        <td><html:hidden property="student" value='<%= s.getId().toString() %>' /></td>
                    </tr>
                    <tr>
                        <td><html:text property="message"/></td>
                        <td><html:submit/></td>
                    </tr>
                </tbody>
            </table>
        </html:form>
        
    </body>
    
</html>
