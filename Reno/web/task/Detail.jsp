<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Detail of Task</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>Detail of Task</h1>
<h:form>
  <h:panelGrid columns="2">
<h:outputText value="Id:"/>
 <h:outputText value="#{task.task.id}" title="Id" />
<h:outputText value="Title:"/>
 <h:outputText value="#{task.task.title}" title="Title" />
<h:outputText value="Description:"/>
 <h:outputText value="#{task.task.description}" title="Description" />
<h:outputText value="StartDate:"/>
 <h:outputText value="#{task.task.startDate}" title="StartDate" />
<h:outputText value="EndDate:"/>
 <h:outputText value="#{task.task.endDate}" title="EndDate" />
<h:outputText value="PlannedCompletionDate:"/>
 <h:outputText value="#{task.task.plannedCompletionDate}" title="PlannedCompletionDate" />
<h:outputText value="CompletionDate:"/>
 <h:outputText value="#{task.task.completionDate}" title="CompletionDate" />
<h:outputText value="AllotedAmount:"/>
 <h:outputText value="#{task.task.allotedAmount}" title="AllotedAmount" />
<h:outputText value="FinishDate:"/>
 <h:outputText value="#{task.task.finishDate}" title="FinishDate" />
<h:outputText value="Priority:"/>
 <h:outputText value="#{task.task.priority}" title="Priority" />
<h:outputText value="PercentageCompleted:"/>
 <h:outputText value="#{task.task.percentageCompleted}" title="PercentageCompleted" />
<h:outputText value="Status:"/>
 <h:outputText value="#{task.task.status}" title="Status" />
<h:outputText value="Project:"/>
 <h:outputText value="#{task.task.project}" title="Project" />
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
 <h:commandLink value="Destroy" action="#{payment.destroyFromTask}">
<f:param name="id" value="#{item.id}"/>
<f:param name="relatedId" value="#{task.task.id}"/>
</h:commandLink>
  <h:outputText value=" "/>
 <h:commandLink value="Edit" action="#{payment.editSetup}">
<f:param name="id" value="#{item.id}"/>
<h:outputText value=" "/>
 </h:commandLink>
<h:commandLink value="Remove" action="#{task.removePaymentCollection}"/></h:column>
</h:dataTable>
<h:panelGroup rendered="#{not empty task.paymentCollectionAvailable}"><br />
<b>Add Payments:</b>
<br />
<h:selectManyListbox id="addPayments" value="#{task.paymentCollectionToAdd}" title="Add PaymentCollection:">
<f:selectItems value="#{task.paymentCollectionAvailable}"/>
</h:selectManyListbox>
<h:commandButton value="Add" action="#{task.addPaymentCollection}"/>
 <br>
</h:panelGroup>
<br />
<h:commandLink value="Add New Payment" action="#{payment.createFromTaskSetup}">
<f:param name="relatedId" value="#{task.task.id}"/>
</h:commandLink>
<br />
<br />
<h:commandLink action="task_edit" value="Edit" />
<br>
<h:commandLink action="task_list" value="Show All Task"/>
<br />
<a href="/Reno/index.jsp">Back to index</a>
</h:form>
 </f:view>
</body>
</html>
