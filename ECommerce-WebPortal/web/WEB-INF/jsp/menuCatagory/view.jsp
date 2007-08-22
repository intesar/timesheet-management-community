<%@ page contentType="text/html" isELIgnored="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="html" tagdir="/WEB-INF/tags/html" %>


<table border="0" cellpadding="4">

<c:forEach items="${model.catagories}" var="catagory">
<tr>

<td>
<a href="<portlet:actionURL>
   <portlet:param name="action" value="viewCatagory"/>
   <portlet:param name="catagory" value="${catagory.id}"/>
    </portlet:actionURL>">${catagory.name}
</a>
</td>

</tr>
</c:forEach>

</table>