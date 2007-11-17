<%-- 
    Document   : newQuery
    Created on : Nov 16, 2007, 11:24:08 PM
    Author     : Amer
--%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Query </title>
    </head>
    <body>
        <html:form action="/queryAction">
            <table>
                <tr>
                    <td> Message : </td>
                    <td> <html:textarea property="message"> </html:textarea> </td>
                </tr>
                <tr>
                    <td> <html:submit> Save </html:submit></td>
                    <td> <html:reset></html:reset></td>
                </tr>
            </table>
            </html:form>
    </body>
</html>
