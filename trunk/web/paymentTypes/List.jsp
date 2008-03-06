<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>List PaymentTypes</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>Listing PaymentTypess</h1>
<h:form>
<h:outputText escape="false" value="(No PaymentTypess Found)<br />" rendered="#{paymentTypes.itemCount == 0}" />
<h:panelGroup rendered="#{paymentTypes.itemCount > 0}">
<h:outputText value="Item #{paymentTypes.firstItem + 1}..#{paymentTypes.lastItem} of #{paymentTypes.itemCount}"/>&nbsp;
<h:commandLink action="#{paymentTypes.prev}" value="Previous #{paymentTypes.batchSize}" rendered="#{paymentTypes.firstItem >= paymentTypes.batchSize}"/>&nbsp;
<h:commandLink action="#{paymentTypes.next}" value="Next #{paymentTypes.batchSize}" rendered="#{paymentTypes.lastItem + paymentTypes.batchSize <= paymentTypes.itemCount}"/>&nbsp;
<h:commandLink action="#{paymentTypes.next}" value="Remaining #{paymentTypes.itemCount - paymentTypes.lastItem}"
rendered="#{paymentTypes.lastItem < paymentTypes.itemCount && paymentTypes.lastItem + paymentTypes.batchSize > paymentTypes.itemCount}"/>
<h:dataTable value='#{paymentTypes.paymentTypess}' var='item' border="1" cellpadding="2" cellspacing="0">
<h:column>
 <f:facet name="header">
 <h:outputText value="Id"/>
 </f:facet>
<h:commandLink action="#{paymentTypes.detailSetup}" value="#{item.id}"/>
 </h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="Code"/>
 </f:facet>
 <h:outputText value="#{item.code}"/>
</h:column>
<h:column>
 <h:commandLink value="Destroy" action="#{paymentTypes.destroy}">
<f:param name="id" value="#{item.id}"/>
</h:commandLink>
  <h:outputText value=" "/>
 <h:commandLink value="Edit" action="#{paymentTypes.editSetup}">
<f:param name="id" value="#{item.id}"/>
</h:commandLink>
 </h:column>
</h:dataTable>
</h:panelGroup>
<br />
<h:commandLink action="#{paymentTypes.createSetup}" value="New PaymentTypes"/>
<br />
<a href="/WebApplication15/index.jsp">Back to index</a>

</h:form>
</f:view>
</body>
</html>
