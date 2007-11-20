<%-- 
    Document   : newGroup
    Created on : Nov 16, 2007, 8:56:20 PM
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
        <title> Create Group </title>
    </head>
    <body>
       <html:link href="home.do" > Home </html:link>
       <html:errors/>
        <html:form action="/groupAction">
            <table>
                <tr>
                    <td> Owner : </td>
                    <td> <html:text property="owner" ></html:text></td>
                </tr>
                <tr>
                    <td> Subcribe email : </td>
                    <td> <html:text property="subscribeEmail" ></html:text> </td>
                </tr>
                <tr>
                    <td> Group email : </td>
                    <td> <html:text property="groupEmail" > </html:text></td>
                </tr>
                <tr>
                    <td> Unsubscribe email : </td>
                    <td> <html:text property="unSubscribeEmail"></html:text></td>
                </tr>
                <tr>
                    <td> <html:submit> Save </html:submit></td>
                    <td> <html:reset></html:reset></td>
                </tr>
            </table>
        </html:form>
    </body>
</html>
