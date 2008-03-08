<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Edit PercentageValues</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>Edit PercentageValues</h1>
<h:form>
  <h:inputHidden value="#{percentageValues.percentageValues}" immediate="true"/>
<h:panelGrid columns="2">
<h:outputText value="PercentageCode:"/>
 <h:outputText value="#{percentageValues.percentageValues.percentageCode}" title="PercentageCode" />
</h:panelGrid>
<br />
<h:commandLink action="#{percentageValues.edit}" value="Save"/>
<br />
<h:commandLink action="percentageValues_list" value="Show All PercentageValues"/>
<br />
<a href="/Reno/index.jsp">Back to index</a>
</h:form>
 </f:view>
</body>
</html>
