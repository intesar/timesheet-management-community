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



<form  method="post" action="<portlet:actionURL>
       <portlet:param name="action" value="search"/>			
       </portlet:actionURL>">
    
    <!-- <input type="text" name="key" value="" /> <input type="submit" value="Search" name="search" /> -->
    <input class="form-text" name="key" size="30" type="text" value="Search..." onBlur="if (this.value == '') { this.value = '\u0053\u0065\u0061\u0072\u0063\u0068\u002e\u002e\u002e'; }" onFocus="if (this.value == '\u0053\u0065\u0061\u0072\u0063\u0068\u002e\u002e\u002e') { this.value = ''; }">
    <input align="absmiddle" border="0" src="/ECommerce-WebPortal/images/search.gif" title="Search" type="image">
</form>

