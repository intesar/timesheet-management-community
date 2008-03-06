<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Detail of PaymentTypes</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>Detail of PaymentTypes</h1>
<h:form>
  <h:panelGrid columns="2">
<h:outputText value="Id:"/>
 <h:outputText value="#{paymentTypes.paymentTypes.id}" title="Id" />
<h:outputText value="Code:"/>
 <h:outputText value="#{paymentTypes.paymentTypes.code}" title="Code" />
</h:panelGrid>
<br />
<b>List of PaymentCollection:</b>
<h:outputText rendered="#{payment.detailPayments.rowCount == 0}" escape="false" value="<br />(No PaymentCollection Found)"/>
<br />
<h:dataTable value="#{payment.detailPayments}" var="item" 
border="1" cellpadding="2" cellspacing="0" 
 rendered="#{payment.detailPayments.rowCount > 0}">
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
 <h:commandLink value="Destroy" action="#{payment.destroyFromPaymentTypes}">
<f:param name="id" value="#{item.id}"/>
<f:param name="relatedId" value="#{paymentTypes.paymentTypes.id}"/>
</h:commandLink>
  <h:outputText value=" "/>
 <h:commandLink value="Edit" action="#{payment.editSetup}">
<f:param name="id" value="#{item.id}"/>
<h:outputText value=" "/>
 </h:commandLink>
<h:commandLink value="Remove" action="#{paymentTypes.removePaymentCollection}"/></h:column>
</h:dataTable>
<h:panelGroup rendered="#{not empty paymentTypes.paymentCollectionAvailable}"><br />
<b>Add Payments:</b>
<br />
<h:selectManyListbox id="addPayments" value="#{paymentTypes.paymentCollectionToAdd}" title="Add PaymentCollection:">
<f:selectItems value="#{paymentTypes.paymentCollectionAvailable}"/>
</h:selectManyListbox>
<h:commandButton value="Add" action="#{paymentTypes.addPaymentCollection}"/>
 <br>
</h:panelGroup>
<br />
<h:commandLink value="Add New Payment" action="#{payment.createFromPaymentTypesSetup}">
<f:param name="relatedId" value="#{paymentTypes.paymentTypes.id}"/>
</h:commandLink>
<br />
<br />
<h:commandLink action="paymentTypes_edit" value="Edit" />
<br>
<h:commandLink action="paymentTypes_list" value="Show All PaymentTypes"/>
<br />
<a href="/WebApplication15/index.jsp">Back to index</a>
</h:form>
 </f:view>
</body>
</html>
