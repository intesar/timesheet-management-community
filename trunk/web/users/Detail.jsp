<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Detail of Users</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>Detail of Users</h1>
<h:form>
  <h:panelGrid columns="2">
<h:outputText value="Id:"/>
 <h:outputText value="#{users.users.id}" title="Id" />
<h:outputText value="Firstname:"/>
 <h:outputText value="#{users.users.firstname}" title="Firstname" />
<h:outputText value="Lastname:"/>
 <h:outputText value="#{users.users.lastname}" title="Lastname" />
<h:outputText value="Email:"/>
 <h:outputText value="#{users.users.email}" title="Email" />
<h:outputText value="OfficePhone:"/>
 <h:outputText value="#{users.users.officePhone}" title="OfficePhone" />
<h:outputText value="MobilePhone:"/>
 <h:outputText value="#{users.users.mobilePhone}" title="MobilePhone" />
<h:outputText value="Fax:"/>
 <h:outputText value="#{users.users.fax}" title="Fax" />
<h:outputText value="OtherPhone:"/>
 <h:outputText value="#{users.users.otherPhone}" title="OtherPhone" />
</h:panelGrid>
<br />
<b>List of UserInvestmentCollection:</b>
<h:outputText rendered="#{userInvestment.detailUserInvestments.rowCount == 0}" escape="false" value="<br />(No UserInvestmentCollection Found)"/>
<br />
<h:dataTable value="#{userInvestment.detailUserInvestments}" var="item" 
border="1" cellpadding="2" cellspacing="0" 
 rendered="#{userInvestment.detailUserInvestments.rowCount > 0}">
<h:column>
 <f:facet name="header">
 <h:outputText value="Id"/>
 </f:facet>
<h:commandLink action="#{userInvestment.detailSetup}" value="#{item.id}"/>
 </h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="Amount"/>
 </f:facet>
 <h:outputText value="#{item.amount}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="TransactionDate"/>
 </f:facet>
 <h:outputText value="#{item.transactionDate}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="Comment"/>
 </f:facet>
 <h:outputText value="#{item.comment}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="UserId"/>
 </f:facet>
 <h:outputText value="#{item.userId}"/>
</h:column>
 <h:column>
 <h:commandLink value="Destroy" action="#{userInvestment.destroyFromUsers}">
<f:param name="id" value="#{item.id}"/>
<f:param name="relatedId" value="#{users.users.id}"/>
</h:commandLink>
  <h:outputText value=" "/>
 <h:commandLink value="Edit" action="#{userInvestment.editSetup}">
<f:param name="id" value="#{item.id}"/>
<h:outputText value=" "/>
 </h:commandLink>
<h:commandLink value="Remove" action="#{users.removeUserInvestmentCollection}"/></h:column>
</h:dataTable>
<h:panelGroup rendered="#{not empty users.userInvestmentCollectionAvailable}"><br />
<b>Add UserInvestments:</b>
<br />
<h:selectManyListbox id="addUserInvestments" value="#{users.userInvestmentCollectionToAdd}" title="Add UserInvestmentCollection:">
<f:selectItems value="#{users.userInvestmentCollectionAvailable}"/>
</h:selectManyListbox>
<h:commandButton value="Add" action="#{users.addUserInvestmentCollection}"/>
 <br>
</h:panelGroup>
<br />
<h:commandLink value="Add New UserInvestment" action="#{userInvestment.createFromUsersSetup}">
<f:param name="relatedId" value="#{users.users.id}"/>
</h:commandLink>
<br />
<br />
<b>List of ProjectCollection:</b>
<h:outputText rendered="#{project.detailProjects.rowCount == 0}" escape="false" value="<br />(No ProjectCollection Found)"/>
<br />
<h:dataTable value="#{project.detailProjects}" var="item" 
border="1" cellpadding="2" cellspacing="0" 
 rendered="#{project.detailProjects.rowCount > 0}">
<h:column>
 <f:facet name="header">
 <h:outputText value="Id"/>
 </f:facet>
<h:commandLink action="#{project.detailSetup}" value="#{item.id}"/>
 </h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="Title"/>
 </f:facet>
 <h:outputText value="#{item.title}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="Description"/>
 </f:facet>
 <h:outputText value="#{item.description}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="EstimatedBudget"/>
 </f:facet>
 <h:outputText value="#{item.estimatedBudget}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="EstimatedStartDate"/>
 </f:facet>
 <h:outputText value="#{item.estimatedStartDate}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="EstimatedFinishDate"/>
 </f:facet>
 <h:outputText value="#{item.estimatedFinishDate}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="CurrentBalance"/>
 </f:facet>
 <h:outputText value="#{item.currentBalance}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="InvestedAmount"/>
 </f:facet>
 <h:outputText value="#{item.investedAmount}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="ManagerId"/>
 </f:facet>
 <h:outputText value="#{item.managerId}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="Status"/>
 </f:facet>
 <h:outputText value="#{item.status}"/>
</h:column>
 <h:column>
 <h:commandLink value="Destroy" action="#{project.destroyFromUsers}">
<f:param name="id" value="#{item.id}"/>
<f:param name="relatedId" value="#{users.users.id}"/>
</h:commandLink>
  <h:outputText value=" "/>
 <h:commandLink value="Edit" action="#{project.editSetup}">
<f:param name="id" value="#{item.id}"/>
<h:outputText value=" "/>
 </h:commandLink>
<h:commandLink value="Remove" action="#{users.removeProjectCollection}"/></h:column>
</h:dataTable>
<h:panelGroup rendered="#{not empty users.projectCollectionAvailable}"><br />
<b>Add Projects:</b>
<br />
<h:selectManyListbox id="addProjects" value="#{users.projectCollectionToAdd}" title="Add ProjectCollection:">
<f:selectItems value="#{users.projectCollectionAvailable}"/>
</h:selectManyListbox>
<h:commandButton value="Add" action="#{users.addProjectCollection}"/>
 <br>
</h:panelGroup>
<br />
<h:commandLink value="Add New Project" action="#{project.createFromUsersSetup}">
<f:param name="relatedId" value="#{users.users.id}"/>
</h:commandLink>
<br />
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
 <h:commandLink value="Destroy" action="#{payment.destroyFromUsers}">
<f:param name="id" value="#{item.id}"/>
<f:param name="relatedId" value="#{users.users.id}"/>
</h:commandLink>
  <h:outputText value=" "/>
 <h:commandLink value="Edit" action="#{payment.editSetup}">
<f:param name="id" value="#{item.id}"/>
<h:outputText value=" "/>
 </h:commandLink>
<h:commandLink value="Remove" action="#{users.removePaymentCollection}"/></h:column>
</h:dataTable>
<h:panelGroup rendered="#{not empty users.paymentCollectionAvailable}"><br />
<b>Add Payments:</b>
<br />
<h:selectManyListbox id="addPayments" value="#{users.paymentCollectionToAdd}" title="Add PaymentCollection:">
<f:selectItems value="#{users.paymentCollectionAvailable}"/>
</h:selectManyListbox>
<h:commandButton value="Add" action="#{users.addPaymentCollection}"/>
 <br>
</h:panelGroup>
<br />
<h:commandLink value="Add New Payment" action="#{payment.createFromUsersSetup}">
<f:param name="relatedId" value="#{users.users.id}"/>
</h:commandLink>
<br />
<br />
<h:commandLink action="users_edit" value="Edit" />
<br>
<h:commandLink action="users_list" value="Show All Users"/>
<br />
<a href="/WebApplication15/index.jsp">Back to index</a>
</h:form>
 </f:view>
</body>
</html>
