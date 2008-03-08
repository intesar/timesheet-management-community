<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Detail of PriorityTypes</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>Detail of PriorityTypes</h1>
<h:form>
  <h:panelGrid columns="2">
<h:outputText value="PriorityCode:"/>
 <h:outputText value="#{priorityTypes.priorityTypes.priorityCode}" title="PriorityCode" />
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
 <h:commandLink value="Destroy" action="#{task.destroyFromPriorityTypes}">
<f:param name="id" value="#{item.id}"/>
<f:param name="relatedId" value="#{priorityTypes.priorityTypes.priorityCode}"/>
</h:commandLink>
  <h:outputText value=" "/>
 <h:commandLink value="Edit" action="#{task.editSetup}">
<f:param name="id" value="#{item.id}"/>
<h:outputText value=" "/>
 </h:commandLink>
<h:commandLink value="Remove" action="#{priorityTypes.removeTaskCollection}"/></h:column>
</h:dataTable>
<h:panelGroup rendered="#{not empty priorityTypes.taskCollectionAvailable}"><br />
<b>Add Tasks:</b>
<br />
<h:selectManyListbox id="addTasks" value="#{priorityTypes.taskCollectionToAdd}" title="Add TaskCollection:">
<f:selectItems value="#{priorityTypes.taskCollectionAvailable}"/>
</h:selectManyListbox>
<h:commandButton value="Add" action="#{priorityTypes.addTaskCollection}"/>
 <br>
</h:panelGroup>
<br />
<h:commandLink value="Add New Task" action="#{task.createFromPriorityTypesSetup}">
<f:param name="relatedId" value="#{priorityTypes.priorityTypes.priorityCode}"/>
</h:commandLink>
<br />
<br />
<h:commandLink action="priorityTypes_edit" value="Edit" />
<br>
<h:commandLink action="priorityTypes_list" value="Show All PriorityTypes"/>
<br />
<a href="/Reno/index.jsp">Back to index</a>
</h:form>
 </f:view>
</body>
</html>
