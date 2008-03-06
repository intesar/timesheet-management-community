<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>New PercentageValues</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>New PercentageValues</h1>
<h:form>
  <h:panelGrid columns="2">
<h:outputText value="Id:"/>
 <h:inputText id="id" value="#{percentageValues.percentageValues.id}" title="Id" />
<h:outputText value="PercentageCode:"/>
 <h:inputText id="percentageCode" value="#{percentageValues.percentageValues.percentageCode}" title="PercentageCode" />
</h:panelGrid>
<br />
<h:commandLink action="#{percentageValues.create}" value="Create"/>
<br />
<h:commandLink action="percentageValues_list" value="Show All PercentageValues"/>
 <br />
<a href="/WebApplication15/index.jsp">Back to index</a>
</h:form>
 </f:view>
</body>
</html>
