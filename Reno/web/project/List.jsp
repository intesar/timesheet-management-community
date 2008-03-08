<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>List Project</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>Listing Projects</h1>
<h:form>
<h:outputText escape="false" value="(No Projects Found)<br />" rendered="#{project.itemCount == 0}" />
<h:panelGroup rendered="#{project.itemCount > 0}">
<h:outputText value="Item #{project.firstItem + 1}..#{project.lastItem} of #{project.itemCount}"/>&nbsp;
<h:commandLink action="#{project.prev}" value="Previous #{project.batchSize}" rendered="#{project.firstItem >= project.batchSize}"/>&nbsp;
<h:commandLink action="#{project.next}" value="Next #{project.batchSize}" rendered="#{project.lastItem + project.batchSize <= project.itemCount}"/>&nbsp;
<h:commandLink action="#{project.next}" value="Remaining #{project.itemCount - project.lastItem}"
rendered="#{project.lastItem < project.itemCount && project.lastItem + project.batchSize > project.itemCount}"/>
<h:dataTable value='#{project.projects}' var='item' border="1" cellpadding="2" cellspacing="0">
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
 <h:commandLink value="Destroy" action="#{project.destroy}">
<f:param name="id" value="#{item.id}"/>
</h:commandLink>
  <h:outputText value=" "/>
 <h:commandLink value="Edit" action="#{project.editSetup}">
<f:param name="id" value="#{item.id}"/>
</h:commandLink>
 </h:column>
</h:dataTable>
</h:panelGroup>
<br />
<h:commandLink action="#{project.createSetup}" value="New Project"/>
<br />
<a href="/Reno/index.jsp">Back to index</a>

</h:form>
</f:view>
</body>
</html>
