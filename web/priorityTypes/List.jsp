<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>List PriorityTypes</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>Listing PriorityTypess</h1>
<h:form>
<h:outputText escape="false" value="(No PriorityTypess Found)<br />" rendered="#{priorityTypes.itemCount == 0}" />
<h:panelGroup rendered="#{priorityTypes.itemCount > 0}">
<h:outputText value="Item #{priorityTypes.firstItem + 1}..#{priorityTypes.lastItem} of #{priorityTypes.itemCount}"/>&nbsp;
<h:commandLink action="#{priorityTypes.prev}" value="Previous #{priorityTypes.batchSize}" rendered="#{priorityTypes.firstItem >= priorityTypes.batchSize}"/>&nbsp;
<h:commandLink action="#{priorityTypes.next}" value="Next #{priorityTypes.batchSize}" rendered="#{priorityTypes.lastItem + priorityTypes.batchSize <= priorityTypes.itemCount}"/>&nbsp;
<h:commandLink action="#{priorityTypes.next}" value="Remaining #{priorityTypes.itemCount - priorityTypes.lastItem}"
rendered="#{priorityTypes.lastItem < priorityTypes.itemCount && priorityTypes.lastItem + priorityTypes.batchSize > priorityTypes.itemCount}"/>
<h:dataTable value='#{priorityTypes.priorityTypess}' var='item' border="1" cellpadding="2" cellspacing="0">
<h:column>
 <f:facet name="header">
 <h:outputText value="Id"/>
 </f:facet>
<h:commandLink action="#{priorityTypes.detailSetup}" value="#{item.id}"/>
 </h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="PriorityCode"/>
 </f:facet>
 <h:outputText value="#{item.priorityCode}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="Task"/>
 </f:facet>
 <h:outputText value="#{item.task}"/>
</h:column>
<h:column>
 <h:commandLink value="Destroy" action="#{priorityTypes.destroy}">
<f:param name="id" value="#{item.id}"/>
</h:commandLink>
  <h:outputText value=" "/>
 <h:commandLink value="Edit" action="#{priorityTypes.editSetup}">
<f:param name="id" value="#{item.id}"/>
</h:commandLink>
 </h:column>
</h:dataTable>
</h:panelGroup>
<br />
<h:commandLink action="#{priorityTypes.createSetup}" value="New PriorityTypes"/>
<br />
<a href="/WebApplication15/index.jsp">Back to index</a>

</h:form>
</f:view>
</body>
</html>
