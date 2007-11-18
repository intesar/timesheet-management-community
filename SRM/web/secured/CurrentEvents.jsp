<%-- 
    Document   : CurrentEvents
    Created on : Nov 18, 2007, 12:08:33 AM
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
    <html>
    
    <body>
         <%
           List<Event> list = (List<Event>) session.getAttribute("list");
            for ( Event o : list ) {
                out.println(o.getDate() );
                out.println (o.getType() );
                out.println (o.getDescript() );
                out.println (o.getType() );
                }%>
        
    </body>
</html>
</html>
