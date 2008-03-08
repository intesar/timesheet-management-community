<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>New Project</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>New Project</h1>
<h:form>
  <h:panelGrid columns="2">
<h:outputText value="Id:"/>
 <h:inputText id="id" value="#{project.project.id}" title="Id" />
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
<h:outputText value="Status:" rendered="#{project.project.status == null}"/>
 <h:selectOneMenu id="status" value="#{project.project.status}" title="Status" rendered="#{project.project.status == null}">
 <f:selectItems value="#{project.statuss}"/>
 </h:selectOneMenu>
<h:outputText value="ManagerId:" rendered="#{project.project.managerId == null}"/>
 <h:selectOneMenu id="managerId" value="#{project.project.managerId}" title="ManagerId" rendered="#{project.project.managerId == null}">
 <f:selectItems value="#{project.managerIds}"/>
 </h:selectOneMenu>
</h:panelGrid>
<br />
<h:commandLink action="#{project.createFromStatusCodes}" value="Create" rendered="#{project.project.status != null and project.project.managerId == null}"/>
<h:commandLink action="#{project.createFromUsers}" value="Create" rendered="#{project.project.managerId != null and project.project.status == null}"/>
<h:commandLink action="#{project.create}" value="Create" rendered="#{project.project.status == null and project.project.managerId == null}"/>
<br />
<h:commandLink action="project_list" value="Show All Project"/>
 <br />
<a href="/Reno/index.jsp">Back to index</a>
</h:form>
 </f:view>
</body>
</html>
