<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>List Payment</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>Listing Payments</h1>
<h:form>
<h:outputText escape="false" value="(No Payments Found)<br />" rendered="#{payment.itemCount == 0}" />
<h:panelGroup rendered="#{payment.itemCount > 0}">
<h:outputText value="Item #{payment.firstItem + 1}..#{payment.lastItem} of #{payment.itemCount}"/>&nbsp;
<h:commandLink action="#{payment.prev}" value="Previous #{payment.batchSize}" rendered="#{payment.firstItem >= payment.batchSize}"/>&nbsp;
<h:commandLink action="#{payment.next}" value="Next #{payment.batchSize}" rendered="#{payment.lastItem + payment.batchSize <= payment.itemCount}"/>&nbsp;
<h:commandLink action="#{payment.next}" value="Remaining #{payment.itemCount - payment.lastItem}"
rendered="#{payment.lastItem < payment.itemCount && payment.lastItem + payment.batchSize > payment.itemCount}"/>
<h:dataTable value='#{payment.payments}' var='item' border="1" cellpadding="2" cellspacing="0">
<h:column>
 <f:facet name="header">
 <h:outputText value="Id"/>
 </f:facet>
<h:commandLink action="#{payment.detailSetup}" value="#{item.id}"/>
 </h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="Amount"/>
 </f:facet>
 <h:outputText value="#{item.amount}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="PaymentDate"/>
 </f:facet>
 <h:outputText value="#{item.paymentDate}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="Comment"/>
 </f:facet>
 <h:outputText value="#{item.comment}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="Task"/>
 </f:facet>
 <h:outputText value="#{item.task}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="PaidTo"/>
 </f:facet>
 <h:outputText value="#{item.paidTo}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="PaymentType"/>
 </f:facet>
 <h:outputText value="#{item.paymentType}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="PercentageTaskCompleted"/>
 </f:facet>
 <h:outputText value="#{item.percentageTaskCompleted}"/>
</h:column>
<h:column>
 <h:commandLink value="Destroy" action="#{payment.destroy}">
<f:param name="id" value="#{item.id}"/>
</h:commandLink>
  <h:outputText value=" "/>
 <h:commandLink value="Edit" action="#{payment.editSetup}">
<f:param name="id" value="#{item.id}"/>
</h:commandLink>
 </h:column>
</h:dataTable>
</h:panelGroup>
<br />
<h:commandLink action="#{payment.createSetup}" value="New Payment"/>
<br />
<a href="/WebApplication15/index.jsp">Back to index</a>

</h:form>
</f:view>
</body>
</html>
