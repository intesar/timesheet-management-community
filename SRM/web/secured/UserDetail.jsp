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
    </head>
    
    <body>
        <%
        
        Users setUser=new Users(3L);
        setUser.setFirstName("   saddam");
        setUser.setLastName( "   hossain");
        setUser.setUsername( "   hossainsadd");
        setUser.setPassword( "   nehi bolunga");
        //setUser.setEnabled("true");
        
        
        //List<Users> list = (List<Users>) session.getAttribute("list");
        
        //for(Users users : list){
        
        //Users users=new Users(3L);
        
       
        //out.println(users.getEnabled());
        
        
        
        
        %>
        
        <table>
                <tr>    
                    <td> FirstName:  <% out.println(setUser.getFirstName());%> </td>
           
                </tr>
                
                <tr>
                    <td> LastName :  <% out.println(setUser.getLastName());%> </td>
                     
                </tr>
                <tr>
                    <td> UserName :  <% out.println(setUser.getUsername()); %></td>
                    
                </tr>
                <tr>
                    <td> Password :  <%out.println(setUser.getPassword());   %></td>
                    
                </tr>
                <tr>
                    <td> <html:submit> Save </html:submit></td>
                    <td> <html:reset></html:reset></td>
                </tr>
            </table>
        
        
    </body>
    
</html>
