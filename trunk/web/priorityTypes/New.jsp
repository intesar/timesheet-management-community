<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>New PriorityTypes</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>New PriorityTypes</h1>
<h:form>
  <h:panelGrid columns="2">
<h:outputText value="Id:"/>
 <h:inputText id="id" value="#{priorityTypes.priorityTypes.id}" title="Id" />
<h:outputText value="PriorityCode:"/>
 <h:inputText id="priorityCode" value="#{priorityTypes.priorityTypes.priorityCode}" title="PriorityCode" />
<h:outputText value="Task:" rendered="#{priorityTypes.priorityTypes.task == null}"/>
 <h:selectOneMenu id="task" value="#{priorityTypes.priorityTypes.task}" title="Task" rendered="#{priorityTypes.priorityTypes.task == null}">
 <f:selectItems value="#{priorityTypes.tasks}"/>
 </h:selectOneMenu>
</h:panelGrid>
<br />
<h:commandLink action="#{priorityTypes.createFromTask}" value="Create" rendered="#{priorityTypes.priorityTypes.task != null}"/>
<h:commandLink action="#{priorityTypes.create}" value="Create" rendered="#{priorityTypes.priorityTypes.task == null}"/>
<br />
<h:commandLink action="priorityTypes_list" value="Show All PriorityTypes"/>
 <br />
<a href="/WebApplication15/index.jsp">Back to index</a>
</h:form>
 </f:view>
</body>
</html>
