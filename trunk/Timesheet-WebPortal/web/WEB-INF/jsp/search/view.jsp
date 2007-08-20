<%@ include file="/WEB-INF/jsp/include.jsp" %>

<%@ page import="javax.portlet.*"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>

<portlet:defineObjects />
<% PortletPreferences prefs = renderRequest.getPreferences();%> 

<form method="post" action="<portlet:actionURL/>" >
    
    <input type="text" name="key" value="" /><input type="submit" value="Search" />
</form>