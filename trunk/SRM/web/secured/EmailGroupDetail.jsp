<%-- 
    Document   : EmailGroupDetail
    Created on : Nov 18, 2007, 7:32:06 PM
    Author     : Sadd
--%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page import="com.abbhsoft.srm.model.*"%>
<%@page import="java.util.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
        
        EmailGroup emailGroup= new EmailGroup(3L);

        emailGroup.setOwner("saddam");
        //emailGroup.setUniversity("Saint State University");
        emailGroup.setGroupEmail("groupEmail");
        emailGroup.setSubscribeEmail("subscribeEmail");
        emailGroup.setUnsubscribeEmail("unsubscribeEmail");
                
         
        //List<Users> list = (List<Users>) session.getAttribute("list");
        
        //for(Users users : list){
        
        //Users users=new Users(3L);
        
       
        //out.println(users.getEnabled());
        
        
        
        
        %>
        
        <table>
                <tr>    
                    <td> Owner:  <% out.println(emailGroup.getOwner());%> </td>
           
                </tr>
                
                <tr>
                    <td> University :  <% out.println(emailGroup.getUniversity());%> </td>
                     
                </tr>
                <tr>
                    <td> GroupEmail : <% out.println(emailGroup.getGroupEmail()); %></td>
                    
                </tr>
                <tr>
                    <td> Subscribe_Email :  <% out.println(emailGroup.getSubscribeEmail());%></td>
                    
                </tr>
                 <tr>
                    <td> UnSubscribe_Email :  <% out.println(emailGroup.getUnsubscribeEmail());%></td>
                    
                </tr>
                <tr>
                    <td> <html:submit> Save </html:submit></td>
                    <td> <html:reset></html:reset></td>
                </tr>
            </table>
        
        
    </body>
</html>
