<%@ page contentType="text/html" isELIgnored="false" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet" %>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="html" tagdir="/WEB-INF/tags/html" %>

<script type="text/javascript" src="http://www.joostdevalk.nl/code/sortable-table/current/sortable.js"></script>




<table class="sortable" id="itemTable" border="0" cellspacing="3" cellpadding="3">
    <thead>
    <tr>
        <th> Image </th>
        <th> Name </th>
        <th> Description </th>
        <th> Contents </th>
    </tr>    
    </thead>
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
        <img src="/ECommerce-WebPortal/images/<%= item.getImgUrl () %>" title="<%= item.getDescription () %>" width="100" height="100" />
    </td>
    <td>
        <input type="hidden" name="itemId" value="<%= item.getId () %>" />
        <input type="hidden" name="name" value="<%= item.getName () %>" />
        <input type="hidden" name="description" value="<%= item.getDescription () %>" />
        <input type="hidden" name="price" value="<%= item.getPrice () %>" />
        <br/>
        <b><%= item.getName () %></b><br/>        
        <b><%= item.getPrice () %></b><br/>        
        <input type="submit" value="Buy Now" name="buyNow" />        
        <input type="submit" value="Add to Cart" name="addToCart" />
    </td>         
    <td>
        <%= item.getDescription() %>
    </td>
    <td>
        <%= item.getItemContentsCollection() %>
    </td>
</form>
</tr>
<% } %>
</tbody>
</table>

