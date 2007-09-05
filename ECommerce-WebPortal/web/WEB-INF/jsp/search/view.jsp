<%@ page contentType="text/html" isELIgnored="false" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet" %>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="html" tagdir="/WEB-INF/tags/html" %>





<form  method="post" action="<portlet:actionURL>
       <portlet:param name="action" value="search"/>			
       </portlet:actionURL>">
    
    
    <input class="form-text" name="key" size="30" type="text" value="Search..." onBlur="if (this.value == '') { this.value = '\u0053\u0065\u0061\u0072\u0063\u0068\u002e\u002e\u002e'; }" onFocus="if (this.value == '\u0053\u0065\u0061\u0072\u0063\u0068\u002e\u002e\u002e') { this.value = ''; }">
    <input align="absmiddle" border="0" src="/ECommerce-WebPortal/images/search.gif" title="Search" type="image">
</form>

