<%@ page contentType="text/html" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="html" tagdir="/WEB-INF/tags/html" %>



<table border="0" cellspacing="3" cellpadding="3">
<tbody>
<%
java.util.Collection<com.abbhsoft.ecommerce.model.Item> items = (java.util.Collection<com.abbhsoft.ecommerce.model.Item>)request.getAttribute ("ITEMS");
for ( com.abbhsoft.ecommerce.model.Item item : items ) {

%>

<tr>
<form  method="post" action="<portlet:actionURL>
       <portlet:param name="action" value="shoppingCartAddItemController"/>			
       </portlet:actionURL>">
    
    <td>
        <img src="images/<%= item.getImgURL () %>" width="400" height="400" alt="images"/>
    </td>
    <td>
        <input type="hidden" name="id" value="<%= item.getId () %>" />
        <input type="hidden" name="name" value="<%= item.getName () %>" />
        <input type="hidden" name="description" value="<%= item.getDescription () %>" />
        <input type="hidden" name="price" value="<%= item.getPrice () %>" />
        <br/>
        <b></b>
        <b></b>
        <input type="submit" value="Buy Now" name="buyNow" />
        <input type="submit" value="Cart to Cart" name="addToCart" />
    </td>            
</form>
</tr>
<% } %>
</tbody>
</table>

