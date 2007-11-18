<%@ page import="com.abbhsoft.srm.model.*" %>
<%@ page import="java.util.*" %>
    
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
            List list = (List) request.getAttribute("list");
            for ( Object o : list ) {
                out.println(o + "<br/>");
            }
        %>
    </body>
</html>
