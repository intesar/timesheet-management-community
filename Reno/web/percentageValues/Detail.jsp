<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Detail of PercentageValues</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>Detail of PercentageValues</h1>
<h:form>
  <h:panelGrid columns="2">
<h:outputText value="PercentageCode:"/>
 <h:outputText value="#{percentageValues.percentageValues.percentageCode}" title="PercentageCode" />
</h:panelGrid>
<br />
<b>List of TaskCollection:</b>
<h:outputText rendered="#{task.detailTasks.rowCount == 0}" escape="false" value="<br />(No TaskCollection Found)"/>
<br />
<h:dataTable value="#{task.detailTasks}" var="item" 
border="1" cellpadding="2" cellspacing="0" 
 rendered="#{task.detailTasks.rowCount > 0}">
<h:column>
 <f:facet name="header">
 <h:outputText value="Id"/>
 </f:facet>
<h:commandLink action="#{task.detailSetup}" value="#{item.id}"/>
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
 <h:outputText value="StartDate"/>
 </f:facet>
 <h:outputText value="#{item.startDate}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="EndDate"/>
 </f:facet>
 <h:outputText value="#{item.endDate}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="PlannedCompletionDate"/>
 </f:facet>
 <h:outputText value="#{item.plannedCompletionDate}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="CompletionDate"/>
 </f:facet>
 <h:outputText value="#{item.completionDate}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="AllotedAmount"/>
 </f:facet>
 <h:outputText value="#{item.allotedAmount}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="FinishDate"/>
 </f:facet>
 <h:outputText value="#{item.finishDate}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="Priority"/>
 </f:facet>
 <h:outputText value="#{item.priority}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="PercentageCompleted"/>
 </f:facet>
 <h:outputText value="#{item.percentageCompleted}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="Status"/>
 </f:facet>
 <h:outputText value="#{item.status}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="Project"/>
 </f:facet>
 <h:outputText value="#{item.project}"/>
</h:column>
 <h:column>
 <h:commandLink value="Destroy" action="#{task.destroyFromPercentageValues}">
<f:param name="id" value="#{item.id}"/>
<f:param name="relatedId" value="#{percentageValues.percentageValues.percentageCode}"/>
</h:commandLink>
  <h:outputText value=" "/>
 <h:commandLink value="Edit" action="#{task.editSetup}">
<f:param name="id" value="#{item.id}"/>
<h:outputText value=" "/>
 </h:commandLink>
<h:commandLink value="Remove" action="#{percentageValues.removeTaskCollection}"/></h:column>
</h:dataTable>
<h:panelGroup rendered="#{not empty percentageValues.taskCollectionAvailable}"><br />
<b>Add Tasks:</b>
<br />
<h:selectManyListbox id="addTasks" value="#{percentageValues.taskCollectionToAdd}" title="Add TaskCollection:">
<f:selectItems value="#{percentageValues.taskCollectionAvailable}"/>
</h:selectManyListbox>
<h:commandButton value="Add" action="#{percentageValues.addTaskCollection}"/>
 <br>
</h:panelGroup>
<br />
<h:commandLink value="Add New Task" action="#{task.createFromPercentageValuesSetup}">
<f:param name="relatedId" value="#{percentageValues.percentageValues.percentageCode}"/>
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
 <h:commandLink value="Destroy" action="#{payment.destroyFromPercentageValues}">
<f:param name="id" value="#{item.id}"/>
<f:param name="relatedId" value="#{percentageValues.percentageValues.percentageCode}"/>
</h:commandLink>
  <h:outputText value=" "/>
 <h:commandLink value="Edit" action="#{payment.editSetup}">
<f:param name="id" value="#{item.id}"/>
<h:outputText value=" "/>
 </h:commandLink>
<h:commandLink value="Remove" action="#{percentageValues.removePaymentCollection}"/></h:column>
</h:dataTable>
<h:panelGroup rendered="#{not empty percentageValues.paymentCollectionAvailable}"><br />
<b>Add Payments:</b>
<br />
<h:selectManyListbox id="addPayments" value="#{percentageValues.paymentCollectionToAdd}" title="Add PaymentCollection:">
<f:selectItems value="#{percentageValues.paymentCollectionAvailable}"/>
</h:selectManyListbox>
<h:commandButton value="Add" action="#{percentageValues.addPaymentCollection}"/>
 <br>
</h:panelGroup>
<br />
<h:commandLink value="Add New Payment" action="#{payment.createFromPercentageValuesSetup}">
<f:param name="relatedId" value="#{percentageValues.percentageValues.percentageCode}"/>
</h:commandLink>
<br />
<br />
<h:commandLink action="percentageValues_edit" value="Edit" />
<br>
<h:commandLink action="percentageValues_list" value="Show All PercentageValues"/>
<br />
<a href="/Reno/index.jsp">Back to index</a>
</h:form>
 </f:view>
</body>
</html>
