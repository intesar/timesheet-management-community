<%-- 
    Document   : new_Campus
    Created on : Nov 16, 2007, 7:55:12 PM
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
        <title>New Campus</title>
    </head>
    <body>
        <html:form action="/campusAction">
            <table>
                <tr>
                    <td> Name: </td>
                    <td> <html:text property="universityId"></html:text> </td>
                </tr>
                <tr>
                    <td> Campus: </td>
                    <td> <html:text property="campus"></html:text> </td>
                </tr>
                <tr>
                    <td colspan="2"> Address: </td>
                </tr>
                <tr>
                    <td> Street </td>
                    <td> <html:text property="street" ></html:text> </td>
                </tr>
                <tr>
                    <td> City </td>
                    <td> <html:text property="city"></html:text></td>
                </tr>
                <tr>
                    <td> State </td>
                    <td> <html:text property="state"></html:text></td>
                </tr>
                <tr>
                    <td> Zip Code</td>
                    <td> <html:text property="zip"></html:text></td>
                </tr>
                <tr>
                    <td> Country </td>
                    <td> <html:text property="country"></html:text></td>
                </tr>
                <tr>
                    <td> Type </td>
                    <td> <html:text property="type" ></html:text></td>
                </tr>
                <tr>
                    <td> <html:submit> Save </html:submit> </td>
                    <td> <html:reset> Clear </html:reset> </td>
                </tr>
            </table>
        </html:form>
    </body>
</html>
