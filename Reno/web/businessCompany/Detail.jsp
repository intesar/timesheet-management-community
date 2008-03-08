<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Detail of BusinessCompany</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>Detail of BusinessCompany</h1>
<h:form>
  <h:panelGrid columns="2">
<h:outputText value="Id:"/>
 <h:outputText value="#{businessCompany.businessCompany.id}" title="Id" />
<h:outputText value="Name:"/>
 <h:outputText value="#{businessCompany.businessCompany.name}" title="Name" />
<h:outputText value="OfficePhone:"/>
 <h:outputText value="#{businessCompany.businessCompany.officePhone}" title="OfficePhone" />
<h:outputText value="Fax:"/>
 <h:outputText value="#{businessCompany.businessCompany.fax}" title="Fax" />
<h:outputText value="Address:"/>
 <h:outputText value="#{businessCompany.businessCompany.address}" title="Address" />
<h:outputText value="MobilePhone:"/>
 <h:outputText value="#{businessCompany.businessCompany.mobilePhone}" title="MobilePhone" />
<h:outputText value="Project:"/>
 <h:outputText value="#{businessCompany.businessCompany.project}" title="Project" />
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
 <h:outputText value="Comment"/>
 </f:facet>
 <h:outputText value="#{item.comment}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="Date"/>
 </f:facet>
 <h:outputText value="#{item.date}"/>
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
 <f:facet name="header">
 <h:outputText value="Task"/>
 </f:facet>
 <h:outputText value="#{item.task}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="PaidToUser"/>
 </f:facet>
 <h:outputText value="#{item.paidToUser}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="PaidToBusiness"/>
 </f:facet>
 <h:outputText value="#{item.paidToBusiness}"/>
</h:column>
 <h:column>
 <h:commandLink value="Destroy" action="#{payment.destroyFromBusinessCompany}">
<f:param name="id" value="#{item.id}"/>
<f:param name="relatedId" value="#{businessCompany.businessCompany.id}"/>
</h:commandLink>
  <h:outputText value=" "/>
 <h:commandLink value="Edit" action="#{payment.editSetup}">
<f:param name="id" value="#{item.id}"/>
<h:outputText value=" "/>
 </h:commandLink>
<h:commandLink value="Remove" action="#{businessCompany.removePaymentCollection}"/></h:column>
</h:dataTable>
<h:panelGroup rendered="#{not empty businessCompany.paymentCollectionAvailable}"><br />
<b>Add Payments:</b>
<br />
<h:selectManyListbox id="addPayments" value="#{businessCompany.paymentCollectionToAdd}" title="Add PaymentCollection:">
<f:selectItems value="#{businessCompany.paymentCollectionAvailable}"/>
</h:selectManyListbox>
<h:commandButton value="Add" action="#{businessCompany.addPaymentCollection}"/>
 <br>
</h:panelGroup>
<br />
<h:commandLink value="Add New Payment" action="#{payment.createFromBusinessCompanySetup}">
<f:param name="relatedId" value="#{businessCompany.businessCompany.id}"/>
</h:commandLink>
<br />
<br />
<h:commandLink action="businessCompany_edit" value="Edit" />
<br>
<h:commandLink action="businessCompany_list" value="Show All BusinessCompany"/>
<br />
<a href="/Reno/index.jsp">Back to index</a>
</h:form>
 </f:view>
</body>
</html>
