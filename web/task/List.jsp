<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>List Task</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>Listing Tasks</h1>
<h:form>
<h:outputText escape="false" value="(No Tasks Found)<br />" rendered="#{task.itemCount == 0}" />
<h:panelGroup rendered="#{task.itemCount > 0}">
<h:outputText value="Item #{task.firstItem + 1}..#{task.lastItem} of #{task.itemCount}"/>&nbsp;
<h:commandLink action="#{task.prev}" value="Previous #{task.batchSize}" rendered="#{task.firstItem >= task.batchSize}"/>&nbsp;
<h:commandLink action="#{task.next}" value="Next #{task.batchSize}" rendered="#{task.lastItem + task.batchSize <= task.itemCount}"/>&nbsp;
<h:commandLink action="#{task.next}" value="Remaining #{task.itemCount - task.lastItem}"
rendered="#{task.lastItem < task.itemCount && task.lastItem + task.batchSize > task.itemCount}"/>
<h:dataTable value='#{task.tasks}' var='item' border="1" cellpadding="2" cellspacing="0">
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
 <h:commandLink value="Destroy" action="#{task.destroy}">
<f:param name="id" value="#{item.id}"/>
</h:commandLink>
  <h:outputText value=" "/>
 <h:commandLink value="Edit" action="#{task.editSetup}">
<f:param name="id" value="#{item.id}"/>
</h:commandLink>
 </h:column>
</h:dataTable>
</h:panelGroup>
<br />
<h:commandLink action="#{task.createSetup}" value="New Task"/>
<br />
<a href="/WebApplication15/index.jsp">Back to index</a>

</h:form>
</f:view>
</body>
</html>
