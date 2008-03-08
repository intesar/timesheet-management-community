<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>List StatusCodes</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>Listing StatusCodess</h1>
<h:form>
<h:outputText escape="false" value="(No StatusCodess Found)<br />" rendered="#{statusCodes.itemCount == 0}" />
<h:panelGroup rendered="#{statusCodes.itemCount > 0}">
<h:outputText value="Item #{statusCodes.firstItem + 1}..#{statusCodes.lastItem} of #{statusCodes.itemCount}"/>&nbsp;
<h:commandLink action="#{statusCodes.prev}" value="Previous #{statusCodes.batchSize}" rendered="#{statusCodes.firstItem >= statusCodes.batchSize}"/>&nbsp;
<h:commandLink action="#{statusCodes.next}" value="Next #{statusCodes.batchSize}" rendered="#{statusCodes.lastItem + statusCodes.batchSize <= statusCodes.itemCount}"/>&nbsp;
<h:commandLink action="#{statusCodes.next}" value="Remaining #{statusCodes.itemCount - statusCodes.lastItem}"
rendered="#{statusCodes.lastItem < statusCodes.itemCount && statusCodes.lastItem + statusCodes.batchSize > statusCodes.itemCount}"/>
<h:dataTable value='#{statusCodes.statusCodess}' var='item' border="1" cellpadding="2" cellspacing="0">
<h:column>
 <f:facet name="header">
 <h:outputText value="Code"/>
 </f:facet>
<h:commandLink action="#{statusCodes.detailSetup}" value="#{item.code}"/>
 </h:column>
<h:column>
 <h:commandLink value="Destroy" action="#{statusCodes.destroy}">
<f:param name="code" value="#{item.code}"/>
</h:commandLink>
  <h:outputText value=" "/>
 <h:commandLink value="Edit" action="#{statusCodes.editSetup}">
<f:param name="code" value="#{item.code}"/>
</h:commandLink>
 </h:column>
</h:dataTable>
</h:panelGroup>
<br />
<h:commandLink action="#{statusCodes.createSetup}" value="New StatusCodes"/>
<br />
<a href="/Reno/index.jsp">Back to index</a>

</h:form>
</f:view>
</body>
</html>
