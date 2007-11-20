<%@ page import="com.abbhsoft.srm.model.*" %>
<%@ page import="com.abbhsoft.srm.base.*" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <title>Dialog demo</title>
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
            function checkPw(dialogFields) {
            if (dialogFields.confirmpw != dialogFields.newpw)
            alert("Confirmation password is different.  Password is unchanged.");
            }
        </script>
    </head>
    <body  class="tundra">
        <a href="home.do">Home</a>
        <%
        List list = (List) request.getAttribute("list");
        int count = 0;
        for ( Object o : list ) {
        count++;
        BaseModel baseModel = (BaseModel) o;
        if ( o instanceof Student ) {
        Student s = (Student) o;
        out.println("<br/> " + o +
        "<button dojoType=\"dijit.form.Button\" onclick=\"dijit.byId('dialog_student_view_" + count + "').show()\">View</button>");
        
        %>
        <html:link href="studentDetailAction.do?studentId=<%= baseModel.getId() %>"> Edit Student</html:link>
        
        
        
        <div dojoType="dijit.Dialog" id="dialog_student_view_<%= count %>" title="Dialog_student" execute="checkPw(arguments[0]);">
            <table>
                <tr>
                    <td><label for="name">First Name: </label></td>
                    <td><label for="name"><%= s.getFirstName() %></label></td>
                    <td><label for="name">Last Name: </label></td>
                    <td><label for="name"><%= s.getLastName() %></label></td>
                </tr>
                <tr>
                    <td><label for="name">Primary Email: </label></td>
                    <td><label for="name"><%= s.getEmail() %></label></td>
                    <td><label for="name">Secondary Email: </label></td>
                    <td><label for="name"><%= s.getSecondaryEmail() %></label></td>
                </tr>
                <tr>
                    <td><label for="name">Home Phone: </label></td>
                    <td><label for="name"><%= s.getHomePhone() %></label></td>
                    <td><label for="name">Mobile Phone: </label></td>
                    <td><label for="name"><%= s.getMobilePhone() %></label></td>
                </tr>
                <tr>
                    <td><label for="name">Fax: </label></td>
                    <td><label for="name"><%= s.getFax() %></label></td>
                    <td><label for="name">Other Phone: </label></td>
                    <td><label for="name"><%= s.getOtherPhone() %></label></td>
                </tr>
                <tr>
                    <td><label for="name">Education: </label></td>
                    <td><label for="name"><%= s.getEducation() %></label></td>
                    <td><label for="name">Visa Status: </label></td>
                    <td><label for="name"><%= s.getVisaStatus() %></label></td>
                </tr>
                <tr>
                    <td><label for="name">Gender: </label></td>
                    <td><label for="name"><%= s.getGender() %></label></td>
                    <td><label for="name">Age: </label></td>
                    <td><label for="name"><%= s.getAge() %></label></td>
                </tr>
                <tr>
                    <td><label for="name">Nationaity: </label></td>
                    <td><label for="name"><%= s.getNationality() %></label></td>
                    <td><label for="name">Refered By: </label></td>
                    <td><label for="name"><%= s.getRefferedBy() %></label></td>
                </tr>
                <tr>
                    <td><label for="name">Expected Start Date: </label></td>
                    <td><label for="name"><%= s.getExpectedStartDate() %></label></td>
                    <td><label for="name">Status: </label></td>
                    <td><label for="name"></label></td>
                </tr>
                
                
            </table>
        </div>
        <%
        }
        if ( o instanceof Event ) {
        Event e = (Event) o;
        out.println( "<br/> "+ o + 
        "<button dojoType=\"dijit.form.Button\" onclick=\"dijit.byId('dialog_event_view_"+count+"').show()\">View</button>" +
        "<button dojoType=\"dijit.form.Button\" onclick=\"dijit.byId('dialog1').show()\">Edit</button>");
        
        %>
        
        <div dojoType="dijit.Dialog" id="dialog_event_view_<%= count %>" title="Dialog_event" execute="checkPw(arguments[0]);">
            <table>
                <tr>
                    <td><label for="name">Event Date: </label></td>
                    <td><label for="name"><%= e.getDate() %></label></td>
                    <td><label for="name">Event Type: </label></td>
                    <td><label for="name"><%= e.getType() %></label></td>
                </tr>  
                
                <tr>
                    <td><label for="name">Event Descript: </label></td>
                    <td><label for="name"><%= e.getDescript()%>></label></td>
                    <td><label for="name">Event Type: </label></td>
                    <td><label for="name"><%= e.getGroup1() %></label></td>
                </tr>  
                
                <tr>
                    <td><label for="name">Event Student: </label></td>
                    <td><label for="name"><%= e.getStudent() %></label></td>
                    <td><label for="name">Event University: </label></td>
                    <td><label for="name"><%= e.getUniversity() %></label></td>
                </tr>  
            </table>
        </div>
        <%        
        
        }
        
        if ( o instanceof University ) {
        University u = (University) o;
        out.println( "<br/> "+ o + 
        "<button dojoType=\"dijit.form.Button\" onclick=\"dijit.byId('dialog_campus_view_"+count+"').show()\">View</button>");
        
        
        %> 
        <html:link href="universityDetailAction.do?universityId=<%= u.getId() %>"> Edit University</html:link>
       
        
        <div dojoType="dijit.Dialog" id="dialog_campus_view_<%= count %>" title="Dialog_campus" execute="checkPw(arguments[0]);"> 
            
            <table>   
                
                <tr>
                    <td><label for="name">Name: </label></td>
                    <td><label for="name"><%= u.getName() %></label></td>
                    <td><label for="name"> City: </label></td>
                    <td><label for="name"></label></td>
                </tr>   
                
                <tr>
                    <td><label for="name"></label></td>
                    <td><label for="name"></label></td>
                    <td><label for="name"> </label></td>
                    <td><label for="name"></label></td>
                </tr>   
                
            </table>
            
        </div>
        
        
        <% 
        }               //END OF if campus
        
        if ( o instanceof EmailGroup ) {
        EmailGroup eg = (EmailGroup) o;
        out.println( "<br/> "+ o + 
        "<button dojoType=\"dijit.form.Button\" onclick=\"dijit.byId('dialog_emialgroup_view_"+count+"').show()\">View</button>" +
        "<button dojoType=\"dijit.form.Button\" onclick=\"dijit.byId('dialog1').show()\">Edit</button>");
        
        
        %>
        
        <div dojoType="dijit.Dialog" id="dialog_event_view_<%= count %>" title="Dialog_emailgroup" execute="checkPw(arguments[0]);">
            
            <table>
                <tr>
                    <td><label for="name">EmailGroup owner: </label></td>
                    <td><label for="name"><%= eg.getOwner() %></label></td>
                    <td><label for="name">EmailGroup sub_em: </label></td>
                    <td><label for="name"><%= eg.getSubscribeEmail() %></label></td>
                </tr>  
                
                <tr>
                    <td><label for="name">EmailGroup university: </label></td>
                    <td><label for="name"><%= eg.getUniversity() %></label></td>
                    <td><label for="name">EmailGroup unsub_em: </label></td>
                    <td><label for="name"><%= eg.getUnsubscribeEmail() %></label></td>
                    
                </tr>  
                
            </table>
        </div>
        
        
        <%
        }               //end if of EmailGroup
        }              //end of forloop
        %>
    </body>
</html>

