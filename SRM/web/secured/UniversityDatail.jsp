<%-- 
    Document   : UniversityDatail
    Created on : Nov 18, 2007, 7:05:21 PM
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
        
        University university=new University(3L);
        university.setName("Saint Cloud State University");
        //university.setStudentCollection("studentCollection");
        //university.setCampusCollection("campusCollection");
        //setUser.setPassword( "   nehi bolunga");
        //setUser.setEnabled("true");
        
        
        //List<Users> list = (List<Users>) session.getAttribute("list");
        
        //for(Users users : list){
        
        //Users users=new Users(3L);
        
       
        //out.println(users.getEnabled());
        
        
        
        
        %>
        
        <table>
                <tr>    
                    <td> Name:  <% out.println(university.getName());%> </td>
           
                </tr>
                
                
                <tr>
                    <td> <html:submit> Save </html:submit></td>
                    <td> <html:reset></html:reset></td>
                </tr>
            </table>
        
        
    </body>
</html>
