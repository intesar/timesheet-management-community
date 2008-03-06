<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>List PercentageValues</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>Listing PercentageValuess</h1>
<h:form>
<h:outputText escape="false" value="(No PercentageValuess Found)<br />" rendered="#{percentageValues.itemCount == 0}" />
<h:panelGroup rendered="#{percentageValues.itemCount > 0}">
<h:outputText value="Item #{percentageValues.firstItem + 1}..#{percentageValues.lastItem} of #{percentageValues.itemCount}"/>&nbsp;
<h:commandLink action="#{percentageValues.prev}" value="Previous #{percentageValues.batchSize}" rendered="#{percentageValues.firstItem >= percentageValues.batchSize}"/>&nbsp;
<h:commandLink action="#{percentageValues.next}" value="Next #{percentageValues.batchSize}" rendered="#{percentageValues.lastItem + percentageValues.batchSize <= percentageValues.itemCount}"/>&nbsp;
<h:commandLink action="#{percentageValues.next}" value="Remaining #{percentageValues.itemCount - percentageValues.lastItem}"
rendered="#{percentageValues.lastItem < percentageValues.itemCount && percentageValues.lastItem + percentageValues.batchSize > percentageValues.itemCount}"/>
<h:dataTable value='#{percentageValues.percentageValuess}' var='item' border="1" cellpadding="2" cellspacing="0">
<h:column>
 <f:facet name="header">
 <h:outputText value="Id"/>
 </f:facet>
<h:commandLink action="#{percentageValues.detailSetup}" value="#{item.id}"/>
 </h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="PercentageCode"/>
 </f:facet>
 <h:outputText value="#{item.percentageCode}"/>
</h:column>
<h:column>
 <h:commandLink value="Destroy" action="#{percentageValues.destroy}">
<f:param name="id" value="#{item.id}"/>
</h:commandLink>
  <h:outputText value=" "/>
 <h:commandLink value="Edit" action="#{percentageValues.editSetup}">
<f:param name="id" value="#{item.id}"/>
</h:commandLink>
 </h:column>
</h:dataTable>
</h:panelGroup>
<br />
<h:commandLink action="#{percentageValues.createSetup}" value="New PercentageValues"/>
<br />
<a href="/WebApplication15/index.jsp">Back to index</a>

</h:form>
</f:view>
</body>
</html>
