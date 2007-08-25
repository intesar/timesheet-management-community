<%@ page contentType="text/html" isELIgnored="false" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet" %>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="html" tagdir="/WEB-INF/tags/html" %>


<link rel="stylesheet" href="http://jquery.bassistance.de/tooltip/jquery.tooltip.css" />
<script src=" http://jquery.bassistance.de/tooltip/jquery.js" type="text/javascript"></script>
<script src="http://jquery.bassistance.de/tooltip/jquery.bgiframe.js " type="text/javascript"></script>
<script src="http://jquery.bassistance.de/tooltip/jquery.dimensions.js" type="text/javascript"></script>
<script src="http://jquery.bassistance.de/tooltip/chili-1.7.pack.js" type="text/javascript"></script>
<script src=" http://jquery.bassistance.de/tooltip/jquery.tooltip.js" type="text/javascript"></script>

<script type="text/javascript">
$(function() {


$('img1').Tooltip({
    track: true,
    delay: 0,
    showURL: false,
    showBody: " - ",
    extraClass: "pretty",
    fixPNG: true,
    opacity: 0.95,
    left: -120
});



$("img").Tooltip({
    track: true,
    delay: 0,
    showURL: false,
    opacity: 1,
    fixPNG: true,
    showBody: " - ",
    extraClass: "pretty fancy",
    top: -15,
    left: 5
});

$('#right a').Tooltip({
    track: true,
    delay: 0,
    showURL: false,
    extraClass: "right"
});
$('#right2 a').Tooltip({ showURL: false });

$("#block").click($.Tooltip.block);

});
</script>


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
        <img src="/ECommerce-WebPortal/images/<%= item.getImgURL () %>" title="<%= item.getDescription () %>" width="100" height="100" />
    </td>
    <td>
        <input type="hidden" name="id" value="<%= item.getId () %>" />
        <input type="hidden" name="name" value="<%= item.getName () %>" />
        <input type="hidden" name="description" value="<%= item.getDescription () %>" />
        <input type="hidden" name="price" value="<%= item.getPrice () %>" />
        <br/>
        <h4><%= item.getName () %></h4>
        <br/>
        <h4><%= item.getPrice () %></h4>        
        <input type="submit" value="Buy Now" name="buyNow" />
        
        <input type="submit" value="Cart to Cart" name="addToCart" />
    </td>            
</form>
</tr>
<% } %>
</tbody>
</table>

