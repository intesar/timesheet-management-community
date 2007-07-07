<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
    <head>
        <title> Registration Page </title>
    </head>
<body>
    <html:form action="/register.do">
    <table border="1">
            <tr>
                <td>Username:</td>
                <td><html:text property="username" value="" /></td>
            </tr>
            <tr>
                <td>Enter Password:</td>
                <td<html:password property="password1" value="" /></td>
            </tr>
            <tr>
                <td>Confirm Password:</td>
                <td><html:password property="password2" value="" /></td>
            </tr>
            <tr>
                <td>First Name:</td>
                <td><html:text property="firstName" value="" /></td>
            </tr>
            <tr>
                <td>Middle Name:</td>
                <td><html:text property="middleName" value="" /></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><html:text property="lastName" value="" /></td>
            </tr>
            <tr>
                <td>Secondary Email:</td>
                <td><html:text property="secondaryEmail" /></td>
            </tr>
            <tr>
                <td>Enter a secret question:</td>
                <td><html:text property="secretQuestion" /></td>
            </tr>
            <tr>
                <td>Your answer:</td>
                <td><html:text property="secretAnswer" /></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td> &nbsp; </td>
            </tr>
            <tr>
                <td>Street:</td>
                <td><html:text property="addressStreet" /></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><html:text property="addressCity" /></td>
            </tr>
            <tr>
                <td>State;</td>
                <td><html:text property="State" /></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><html:text property="addressCountry" /></td>
            </tr>
            <tr>
                <td>Zipcode:</td>
                <td><html:text property="addressZipcode" /></td>
            </tr>
            <tr>
                <td>Company name:</td>
                <td><html:text property="company" /></td>
            </tr>
            <tr>
                <td>Your title:</td>
                <td><html:text property="title" /></td>
            </tr>
            <tr>
                <td>Company Summary:</td>
                <td><html:textarea property="summary" /></td>
            </tr>
            <tr>
            <td colspan="2" align="center"><html:submit/></td>
            </tr>
        </table>
    </html:form>
</body>
</html>