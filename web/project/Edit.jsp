<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Edit Project</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>Edit Project</h1>
<h:form>
  <h:inputHidden value="#{project.project}" immediate="true"/>
<h:panelGrid columns="2">
<h:outputText value="Id:"/>
 <h:outputText value="#{project.project.id}" title="Id" />
<h:outputText value="Title:"/>
 <h:inputText id="title" value="#{project.project.title}" title="Title" />
<h:outputText value="Description:"/>
 <h:inputText id="description" value="#{project.project.description}" title="Description" />
<h:outputText value="EstimatedBudget:"/>
 <h:inputText id="estimatedBudget" value="#{project.project.estimatedBudget}" title="EstimatedBudget" />
<h:outputText value="EstimatedStartDate:"/>
 <h:inputText id="estimatedStartDate" value="#{project.project.estimatedStartDate}" title="EstimatedStartDate" />
<h:outputText value="EstimatedFinishDate:"/>
 <h:inputText id="estimatedFinishDate" value="#{project.project.estimatedFinishDate}" title="EstimatedFinishDate" />
<h:outputText value="CurrentBalance:"/>
 <h:inputText id="currentBalance" value="#{project.project.currentBalance}" title="CurrentBalance" />
<h:outputText value="InvestedAmount:"/>
 <h:inputText id="investedAmount" value="#{project.project.investedAmount}" title="InvestedAmount" />
<h:outputText value="ManagerId:"/>
 <h:selectOneMenu id="managerId" value="#{project.project.managerId}" title="ManagerId">
 <f:selectItems value="#{project.managerIds}"/>
 </h:selectOneMenu>
<h:outputText value="Status:"/>
 <h:selectOneMenu id="status" value="#{project.project.status}" title="Status">
 <f:selectItems value="#{project.statuss}"/>
 </h:selectOneMenu>
</h:panelGrid>
<br />
<h:commandLink action="#{project.edit}" value="Save"/>
<br />
<h:commandLink action="project_list" value="Show All Project"/>
<br />
<a href="/WebApplication15/index.jsp">Back to index</a>
</h:form>
 </f:view>
</body>
</html>
