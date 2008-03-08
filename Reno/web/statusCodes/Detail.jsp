<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Detail of StatusCodes</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>Detail of StatusCodes</h1>
<h:form>
  <h:panelGrid columns="2">
<h:outputText value="Code:"/>
 <h:outputText value="#{statusCodes.statusCodes.code}" title="Code" />
</h:panelGrid>
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
 <h:outputText value="Status"/>
 </f:facet>
 <h:outputText value="#{item.status}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="ManagerId"/>
 </f:facet>
 <h:outputText value="#{item.managerId}"/>
</h:column>
 <h:column>
 <h:commandLink value="Destroy" action="#{project.destroyFromStatusCodes}">
<f:param name="id" value="#{item.id}"/>
<f:param name="relatedId" value="#{statusCodes.statusCodes.code}"/>
</h:commandLink>
  <h:outputText value=" "/>
 <h:commandLink value="Edit" action="#{project.editSetup}">
<f:param name="id" value="#{item.id}"/>
<h:outputText value=" "/>
 </h:commandLink>
<h:commandLink value="Remove" action="#{statusCodes.removeProjectCollection}"/></h:column>
</h:dataTable>
<h:panelGroup rendered="#{not empty statusCodes.projectCollectionAvailable}"><br />
<b>Add Projects:</b>
<br />
<h:selectManyListbox id="addProjects" value="#{statusCodes.projectCollectionToAdd}" title="Add ProjectCollection:">
<f:selectItems value="#{statusCodes.projectCollectionAvailable}"/>
</h:selectManyListbox>
<h:commandButton value="Add" action="#{statusCodes.addProjectCollection}"/>
 <br>
</h:panelGroup>
<br />
<h:commandLink value="Add New Project" action="#{project.createFromStatusCodesSetup}">
<f:param name="relatedId" value="#{statusCodes.statusCodes.code}"/>
</h:commandLink>
<br />
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
 <h:commandLink value="Destroy" action="#{task.destroyFromStatusCodes}">
<f:param name="id" value="#{item.id}"/>
<f:param name="relatedId" value="#{statusCodes.statusCodes.code}"/>
</h:commandLink>
  <h:outputText value=" "/>
 <h:commandLink value="Edit" action="#{task.editSetup}">
<f:param name="id" value="#{item.id}"/>
<h:outputText value=" "/>
 </h:commandLink>
<h:commandLink value="Remove" action="#{statusCodes.removeTaskCollection}"/></h:column>
</h:dataTable>
<h:panelGroup rendered="#{not empty statusCodes.taskCollectionAvailable}"><br />
<b>Add Tasks:</b>
<br />
<h:selectManyListbox id="addTasks" value="#{statusCodes.taskCollectionToAdd}" title="Add TaskCollection:">
<f:selectItems value="#{statusCodes.taskCollectionAvailable}"/>
</h:selectManyListbox>
<h:commandButton value="Add" action="#{statusCodes.addTaskCollection}"/>
 <br>
</h:panelGroup>
<br />
<h:commandLink value="Add New Task" action="#{task.createFromStatusCodesSetup}">
<f:param name="relatedId" value="#{statusCodes.statusCodes.code}"/>
</h:commandLink>
<br />
<br />
<h:commandLink action="statusCodes_edit" value="Edit" />
<br>
<h:commandLink action="statusCodes_list" value="Show All StatusCodes"/>
<br />
<a href="/Reno/index.jsp">Back to index</a>
</h:form>
 </f:view>
</body>
</html>
