<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Detail of Project</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>Detail of Project</h1>
<h:form>
  <h:panelGrid columns="2">
<h:outputText value="Id:"/>
 <h:outputText value="#{project.project.id}" title="Id" />
<h:outputText value="Title:"/>
 <h:outputText value="#{project.project.title}" title="Title" />
<h:outputText value="Description:"/>
 <h:outputText value="#{project.project.description}" title="Description" />
<h:outputText value="EstimatedBudget:"/>
 <h:outputText value="#{project.project.estimatedBudget}" title="EstimatedBudget" />
<h:outputText value="EstimatedStartDate:"/>
 <h:outputText value="#{project.project.estimatedStartDate}" title="EstimatedStartDate" />
<h:outputText value="EstimatedFinishDate:"/>
 <h:outputText value="#{project.project.estimatedFinishDate}" title="EstimatedFinishDate" />
<h:outputText value="CurrentBalance:"/>
 <h:outputText value="#{project.project.currentBalance}" title="CurrentBalance" />
<h:outputText value="InvestedAmount:"/>
 <h:outputText value="#{project.project.investedAmount}" title="InvestedAmount" />
<h:outputText value="ManagerId:"/>
 <h:outputText value="#{project.project.managerId}" title="ManagerId" />
<h:outputText value="Status:"/>
 <h:outputText value="#{project.project.status}" title="Status" />
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
 <h:outputText value="Priority"/>
 </f:facet>
 <h:outputText value="#{item.priority}"/>
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
 <h:outputText value="Project"/>
 </f:facet>
 <h:outputText value="#{item.project}"/>
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
 <h:outputText value="PriorityTypes"/>
 </f:facet>
 <h:outputText value="#{item.priorityTypes}"/>
</h:column>
 <h:column>
 <h:commandLink value="Destroy" action="#{task.destroyFromProject}">
<f:param name="id" value="#{item.id}"/>
<f:param name="relatedId" value="#{project.project.id}"/>
</h:commandLink>
  <h:outputText value=" "/>
 <h:commandLink value="Edit" action="#{task.editSetup}">
<f:param name="id" value="#{item.id}"/>
<h:outputText value=" "/>
 </h:commandLink>
<h:commandLink value="Remove" action="#{project.removeTaskCollection}"/></h:column>
</h:dataTable>
<h:panelGroup rendered="#{not empty project.taskCollectionAvailable}"><br />
<b>Add Tasks:</b>
<br />
<h:selectManyListbox id="addTasks" value="#{project.taskCollectionToAdd}" title="Add TaskCollection:">
<f:selectItems value="#{project.taskCollectionAvailable}"/>
</h:selectManyListbox>
<h:commandButton value="Add" action="#{project.addTaskCollection}"/>
 <br>
</h:panelGroup>
<br />
<h:commandLink value="Add New Task" action="#{task.createFromProjectSetup}">
<f:param name="relatedId" value="#{project.project.id}"/>
</h:commandLink>
<br />
<br />
<h:commandLink action="project_edit" value="Edit" />
<br>
<h:commandLink action="project_list" value="Show All Project"/>
<br />
<a href="/WebApplication15/index.jsp">Back to index</a>
</h:form>
 </f:view>
</body>
</html>
