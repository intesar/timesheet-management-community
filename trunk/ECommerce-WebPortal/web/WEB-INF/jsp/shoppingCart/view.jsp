<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%-- Uncomment below lines to add portlet taglibs to jsp
<%@ page import="javax.portlet.*"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>

<portlet:defineObjects />
<%PortletPreferences prefs = renderRequest.getPreferences();%> 
--%>

<b>HelloWorld - VIEW MODE</b>

<% 
com.abbhsoft.shoppingcart.ShoppingCart shoppingCart = (ShoppingCart) request.getSession ().getAttribute ("SHOPPING_CART");

if ( shoppingCart == null ) {
    out.println ( " Cart Empty! ");
} else {
%>
<FORM method="POST" action="https://sandbox.google.com/checkout/cws/v2/Merchant/1234567890/checkoutForm" accept-charset="utf-8">
    
    <TABLE>
        <TH>
            ID
        </TH>
        <TH>
            Name
        </TH>
        <TH>
            Quantity
        </TH>
        <TH>
            Price
        </TH>        
        
        <% 
        java.util.Collection<CartItem> cartItems = shoppingCart.getCartItems ();
        int count = 1;
        for ( com.abbhsoft.shoppingcart.CartItem cartItem : cartItems ) {
        %>
        
        <TR>
            <TD>
                <input type="hidden" name='item_name_<%= count++ %>' value="<%= cartItem.getId () %>"/>
                <input type="text" name="item_name_<%= cartItem.getId () %>" value="<%= cartItem.getId () %>"/>
            </TD>
            <TD>
                <input type="hidden" name="item_description_<%= count++ %>" value="<%= cartItem.getName () %>"/>
                <input type="text" name="item_description_<%= cartItem.getId () %>" value="<%= cartItem.getName () %>"/>
            </TD>
            <TD>
                <input type="hidden" name="item_quantity_<%= count++ %>" value="1"/>
                <input type="text" name="item_quantity_<%= cartItem.getId () %>" value="<%= cartItem.getQuantity () %>"/>
            </TD>
            <TD>
                <input type="hidden" name="item_price_<%= count++ %>" value="3.99"/>
                <input type="text" name="item_price_<%= cartItem.getId () %>" value="<%= cartItem.getPrice () %>"/>  
            </TD>    
        </TR>
        <%
        }
        %>
        
    </TABLE>
    
    <input type="hidden" name="ship_method_name_1" value="PICK UP"/>
    <input type="hidden" name="ship_method_price_1" value="0.0"/>
    
    <input type="hidden" name="tax_rate" value="0.0875"/>
    <input type="hidden" name="tax_us_state" value="PA"/>
    
    <input type="hidden" name="_charset_"/>
    
    <input type="image" name="Google Checkout" alt="Fast checkout through Google" 
           src="http://sandbox.google.com/checkout/buttons/checkout.gif?merchant_id=1234567890&w=180&h=46&style=white&variant=text&loc=en_US" 
           height="46" width="180"/>
    
</FORM>
<%
}
%>

%>