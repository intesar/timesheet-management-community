<%@ page contentType="text/html" isELIgnored="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="html" tagdir="/WEB-INF/tags/html" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
" http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Shopping Cart</title>
    <script type="text/javascript" src="jquery.tablesorter/jquery-1.1.3.js"></script>
    <script type="text/javascript" src="jquery.tablesorter/jquery.tablesorter.pack.js"></script>
    
    <link rel="stylesheet" type="text/css" href="jquery.tablesorter/doc/js/chili/javascript.css" />
    
    <link rel="stylesheet" type="text/css" href="jquery.tablesorter/doc/js/chili/html.css" />
    
    <link rel="stylesheet" type="text/css" href="jquery.tablesorter/doc/js/chili/css.css" />
    
    <link rel="stylesheet" href="jquery.tablesorter/doccss/jq.css" type="text/css" media="print, projection, screen" />
    <link rel="stylesheet" href="jquery.tablesorter/themes/blue/style.css" type="text/css" id="" media="print, projection, screen" />
</head>
<script type="text/javascript" id="js">
        $(function() {
 $("#myTable").tablesorter({sortList:[[0,0],[2,1]], widgets: ['zebra']});
 });
 
</script>
<body>
<%    
com.abbhsoft.shoppingcart.ShoppingCart sp = (com.abbhsoft.shoppingcart.ShoppingCart)request.getSession ().getAttribute ("SHOPPING_CART");
if ( sp == null )  {
    %>
    <B> Cart Empty </B>
<%
    } else {
%>
<form  method="post" action="<portlet:actionURL>
       <portlet:param name="action" value="updateShoppingCart"/>			
       </portlet:actionURL>">
    <table id="myTable" border="0" cellspacing="5" cellpadding="5"  class="tablesorter">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Quantity</th>
                <th>Price</th>                        
                <th>Sub-Total</th>
            </tr>
        </thead>
        <tbody>
            <%
            int count = 1;
            Double total = 0.0;
            for ( com.abbhsoft.shoppingcart.CartItem i : sp.getCartItems () ) {
            %>
            <tr>
                <td>
                    <input type="hidden" name="item_name_<%= count %>" value="<%= i.getId () %>" />
                    <%= i.getId () %>
                </td>
                <td>
                    <%= i.getName () %>
                </td>
                <td>
                    <%= i.getDescription () %>
                </td>
                <td>
                    <input type="text" name="item_quantity_<%= count++ %>" value="<%= i.getQuantity () %>" size="4" />
                </td>
                <td>
                    <%= i.getPrice () %>
                </td>                       
                <td>
                    <%= i.subTotal ()   %>
                </td>
            </tr>
            <%
            
            }
            %>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td><input type="submit" value="Update" name="update" /></td>
                <td><b> Total   </b></td>
                <td><b> <%= sp.getGrossTotal () %> </b></td>
            </tr>
        </tbody>
    </table>            
</form>

<form name="google">
    
    <%
    count = 1;
    for ( com.abbhsoft.shoppingcart.CartItem i : sp.getCartItems () ) {
    %>
    <input type="hidden" name="item_name_<%= count %>" value="<%= i.getName () %>" /> 
    <input type="hidden" name="item_description_<%= count %>" value="<%= i.getDescription () %>" /> 
    <input type="hidden" name="item_quantity_<%= count %>" value="<%= i.getQuantity () %>" /> 
    <input type="hidden" name="item_price_<%= count %>" value="<%= i.getPrice () %>" /> 
    
    <%
    count++;
    }
    %>     
    <input type="hidden" name="ship_method_name_1" value="<%= sp.getShippingMethod () %>"/>
    <input type="hidden" name="ship_method_price_1" value="<%= sp.getShippingMethodPrice () %>"/>
    
    <input type="hidden" name="tax_rate" value="<%= sp.getTaxRate () %>"/>
    <input type="hidden" name="tax_us_state" value="<%= sp.getTaxUsState () %>"/>
    
    <input type="hidden" name="_charset_"/>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="image" name="Google Checkout" alt="Fast checkout through Google" 
                                                           src="http://sandbox.google.com/checkout/buttons/checkout.gif?merchant_id=1234567890&w=180&h=46&style=white&variant=text&loc=en_US" 
                                                           height="46" width="180"/>
    
</form>

<%
}
%>

</body>

</html>