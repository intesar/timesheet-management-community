<%@ page contentType="text/html" isELIgnored="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="html" tagdir="/WEB-INF/tags/html" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu</title>
<script type="text/javascript" src="jquery.tablesorter/jquery-1.1.3.js"></script>
<script type="text/javascript" src="jquery.tablesorter/jquery.tablesorter.pack.js"></script>

<link rel="stylesheet" type="text/css" href="jquery.tablesorter/doc/js/chili/javascript.css" />

<link rel="stylesheet" type="text/css" href="jquery.tablesorter/doc/js/chili/html.css" />

<link rel="stylesheet" type="text/css" href="jquery.tablesorter/doc/js/chili/css.css" />

<link rel="stylesheet" href="jquery.tablesorter/doccss/jq.css" type="text/css" media="print, projection, screen" />
<link rel="stylesheet" href="jquery.tablesorter/themes/blue/style.css" type="text/css" id="" media="print, projection, screen" />

<script type="text/javascript" id="js">
        $(function() {
 $("#myTable").tablesorter({sortList:[[0,0],[2,1]], widgets: ['zebra']});
 });
 
</script>

<table id="myTable" border="0" cellspacing="5" cellpadding="5"  class="tablesorter">
<thead>
    <tr>
        <th>Menu Catagories</th>
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