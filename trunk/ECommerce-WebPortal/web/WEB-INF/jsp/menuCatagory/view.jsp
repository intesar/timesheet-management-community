<%@ page contentType="text/html" isELIgnored="false" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="html" tagdir="/WEB-INF/tags/html" %>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="http://www.joostdevalk.nl/default.css"/>
<link type="text/css" rel="stylesheet"href="http://www.joostdevalk.nl/code/sortable-table/example.css"/>

<script type="text/javascript" src="http://www.joostdevalk.nl/code/sortable-table/current/sortable.js"></script>


<table  class="sortable" id="myTable" border="0" cellspacing="5" cellpadding="5"  >
<thead>
    <tr>
        <th></th>
    </tr>    
</thead>

<c:forEach items="${model.catagories}" var="catagory">
<tr>

<td>
<a href="<portlet:actionURL>
   <portlet:param name="action" value="getCatagoryItem"/>
   <portlet:param name="catagory" value="${catagory.id}"/>
    </portlet:actionURL>">${catagory.name}
</a>
</td>

</tr>
</c:forEach>

</table>