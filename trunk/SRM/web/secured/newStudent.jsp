<%-- 
    Document   : newStudent
    Created on : Nov 16, 2007, 10:03:31 PM
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
        <title> New Student </title>
    </head>
    <body>
        <a href="home.do">Home</a>
        <html:form action="/studentAction">
            <table>
                <tr>
                    <td> First Name : </td>
                    <td> <html:text property="firstName"></html:text></td>
                </tr>
                <tr>
                    <td> Last Name : </td>
                    <td> <html:text property="lastName"></html:text></td>
                </tr>
                <tr>
                    <td> MI : </td>
                    <td> <html:text property="mi"></html:text></td>
                </tr>
                <tr>
                    <td> Email : </td>
                    <td> <html:text property="email"></html:text></td>
                </tr>
                <tr>
                    <td> Secondary Email : </td>
                    <td> <html:text property="secondaryEmail"></html:text></td>
                </tr>
                <tr>
                    <td> Mobile Phone : </td>
                    <td> <html:text property="mobilePhone"></html:text></td>
                </tr>
                <tr>
                    <td> Home Phone : </td>
                    <td> <html:text property="homePhone"></html:text></td>
                </tr>
                <tr>
                    <td> Fax : </td>
                    <td> <html:text property="fax"></html:text> </td>
                </tr>
                <tr>
                    <td> Other Phone : </td>
                    <td> <html:text property="otherPhone"></html:text></td>
                </tr>
                <tr>
                    <td> Education : </td>
                    <td> <html:text property="education"></html:text></td>
                </tr>
                <tr>
                    <td> University Id : </td>
                    <td> <html:text property="universityId"></html:text></td>
                </tr>
                <tr>
                    <td> Visa Status : </td>
                    <td> <html:text property="visaStatus"></html:text></td>
                </tr>
                <tr>
                    <td> Gender : </td>
                    <td> <html:text property="gender"></html:text></td>
                </tr>
                <tr>
                    <td> Age : </td>
                    <td> <html:text property="age"></html:text></td>
                </tr>
                <tr>
                    <td> Nationality : </td>
                    <td> <html:text property="nationality"></html:text></td>
                </tr>
                <tr>
                    <td> Referred By : </td>
                    <td> <html:text property="referredBy"> </html:text></td>
                </tr>
                <tr>
                    <td colspan="2"> Address </td>
                </tr>
                <tr>
                    <td> Street : </td>
                    <td> <html:text property="street"></html:text></td>
                </tr>
                <tr>
                    <td> City : </td>
                    <td> <html:text property="city"></html:text></td>
                </tr>
                <tr>
                    <td> State : </td>
                    <td> <html:text property="state"></html:text></td>
                </tr>
                <tr>
                    <td> Zip Code : </td>
                    <td> <html:text property="zip"></html:text></td>
                </tr>
                <tr>
                    <td> Country : </td>
                    <td> <html:text property="country"></html:text></td>
                </tr>
                <tr>
                    <td> Type : </td>
                    <td> <html:text property="type"></html:text></td>
                </tr>
                <tr>
                    <td> <html:submit> Save </html:submit></td>
                    <td> <html:reset></html:reset></td>
                </tr>
            </table>
            </html:form>
    </body>
</html>
