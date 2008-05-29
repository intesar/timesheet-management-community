<%@ page import="org.acegisecurity.ui.AbstractProcessingFilter" %>
<%@ page import="org.acegisecurity.AuthenticationException" %>
<html>
<head><title>Do formbased login</title></head>
<body>
<h1>Do formbased login</h1>

<% if (request.getParameter("login_error") != null && !"".equals(request.getParameter("login_error"))) {%>
  <div style="color: red">
    <p>Your login attempt was not successful.</p>
    <% if (session.getAttribute(AbstractProcessingFilter.ACEGI_SECURITY_LAST_EXCEPTION_KEY) != null) {%>
    <p>Reason: <%= ((AuthenticationException) session.getAttribute(AbstractProcessingFilter.ACEGI_SECURITY_LAST_EXCEPTION_KEY)).getMessage() %></p>
    <% } %>
  </div>
<% } %>

<form action="j_acegi_security_check" method="post">
  <table>
    <tr>
      <td>Username:</td>
      <td><input type="text" name="j_username"/></td>
    </tr>
    <tr>
      <td>Password:</td>
      <td><input type="password" name="j_password"/></td>
    </tr>
    <tr>
      <td>Remember me:</td>
      <td><input type="checkbox" name="_acegi_security_remember_me"/></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><input type="submit" value="login"/></td>
    </tr>
  </table>
</form>

<p>Go to <a href="secure/securecontent.jsp">secure area</a></p>

</body>
</html>