<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>New Task</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>New Task</h1>
<h:form>
  <h:panelGrid columns="2">
<h:outputText value="Id:"/>
 <h:inputText id="id" value="#{task.task.id}" title="Id" />
<h:outputText value="Title:"/>
 <h:inputText id="title" value="#{task.task.title}" title="Title" />
<h:outputText value="Description:"/>
 <h:inputText id="description" value="#{task.task.description}" title="Description" />
<h:outputText value="StartDate:"/>
 <h:inputText id="startDate" value="#{task.task.startDate}" title="StartDate" />
<h:outputText value="EndDate:"/>
 <h:inputText id="endDate" value="#{task.task.endDate}" title="EndDate" />
<h:outputText value="PlannedCompletionDate:"/>
 <h:inputText id="plannedCompletionDate" value="#{task.task.plannedCompletionDate}" title="PlannedCompletionDate" />
<h:outputText value="CompletionDate:"/>
 <h:inputText id="completionDate" value="#{task.task.completionDate}" title="CompletionDate" />
<h:outputText value="AllotedAmount:"/>
 <h:inputText id="allotedAmount" value="#{task.task.allotedAmount}" title="AllotedAmount" />
<h:outputText value="FinishDate:"/>
 <h:inputText id="finishDate" value="#{task.task.finishDate}" title="FinishDate" />
<h:outputText value="Priority:" rendered="#{task.task.priority == null}"/>
 <h:selectOneMenu id="priority" value="#{task.task.priority}" title="Priority" rendered="#{task.task.priority == null}">
 <f:selectItems value="#{task.prioritys}"/>
 </h:selectOneMenu>
<h:outputText value="PercentageCompleted:" rendered="#{task.task.percentageCompleted == null}"/>
 <h:selectOneMenu id="percentageCompleted" value="#{task.task.percentageCompleted}" title="PercentageCompleted" rendered="#{task.task.percentageCompleted == null}">
 <f:selectItems value="#{task.percentageCompleteds}"/>
 </h:selectOneMenu>
<h:outputText value="Status:" rendered="#{task.task.status == null}"/>
 <h:selectOneMenu id="status" value="#{task.task.status}" title="Status" rendered="#{task.task.status == null}">
 <f:selectItems value="#{task.statuss}"/>
 </h:selectOneMenu>
<h:outputText value="Project:" rendered="#{task.task.project == null}"/>
 <h:selectOneMenu id="project" value="#{task.task.project}" title="Project" rendered="#{task.task.project == null}">
 <f:selectItems value="#{task.projects}"/>
 </h:selectOneMenu>
</h:panelGrid>
<br />
<h:commandLink action="#{task.createFromPriorityTypes}" value="Create" rendered="#{task.task.priority != null and task.task.percentageCompleted == null and task.task.status == null and task.task.project == null}"/>
<h:commandLink action="#{task.createFromPercentageValues}" value="Create" rendered="#{task.task.percentageCompleted != null and task.task.priority == null and task.task.status == null and task.task.project == null}"/>
<h:commandLink action="#{task.createFromStatusCodes}" value="Create" rendered="#{task.task.status != null and task.task.priority == null and task.task.percentageCompleted == null and task.task.project == null}"/>
<h:commandLink action="#{task.createFromProject}" value="Create" rendered="#{task.task.project != null and task.task.priority == null and task.task.percentageCompleted == null and task.task.status == null}"/>
<h:commandLink action="#{task.create}" value="Create" rendered="#{task.task.priority == null and task.task.percentageCompleted == null and task.task.status == null and task.task.project == null}"/>
<br />
<h:commandLink action="task_list" value="Show All Task"/>
 <br />
<a href="/Reno/index.jsp">Back to index</a>
</h:form>
 </f:view>
</body>
</html>
