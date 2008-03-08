<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>List Users</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>Listing Userss</h1>
<h:form>
<h:outputText escape="false" value="(No Userss Found)<br />" rendered="#{users.itemCount == 0}" />
<h:panelGroup rendered="#{users.itemCount > 0}">
<h:outputText value="Item #{users.firstItem + 1}..#{users.lastItem} of #{users.itemCount}"/>&nbsp;
<h:commandLink action="#{users.prev}" value="Previous #{users.batchSize}" rendered="#{users.firstItem >= users.batchSize}"/>&nbsp;
<h:commandLink action="#{users.next}" value="Next #{users.batchSize}" rendered="#{users.lastItem + users.batchSize <= users.itemCount}"/>&nbsp;
<h:commandLink action="#{users.next}" value="Remaining #{users.itemCount - users.lastItem}"
rendered="#{users.lastItem < users.itemCount && users.lastItem + users.batchSize > users.itemCount}"/>
<h:dataTable value='#{users.userss}' var='item' border="1" cellpadding="2" cellspacing="0">
<h:column>
 <f:facet name="header">
 <h:outputText value="Id"/>
 </f:facet>
<h:commandLink action="#{users.detailSetup}" value="#{item.id}"/>
 </h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="Firstname"/>
 </f:facet>
 <h:outputText value="#{item.firstname}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="Lastname"/>
 </f:facet>
 <h:outputText value="#{item.lastname}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="Email"/>
 </f:facet>
 <h:outputText value="#{item.email}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="OfficePhone"/>
 </f:facet>
 <h:outputText value="#{item.officePhone}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="MobilePhone"/>
 </f:facet>
 <h:outputText value="#{item.mobilePhone}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="Fax"/>
 </f:facet>
 <h:outputText value="#{item.fax}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="OtherPhone"/>
 </f:facet>
 <h:outputText value="#{item.otherPhone}"/>
</h:column>
<h:column>
 <h:commandLink value="Destroy" action="#{users.destroy}">
<f:param name="id" value="#{item.id}"/>
</h:commandLink>
  <h:outputText value=" "/>
 <h:commandLink value="Edit" action="#{users.editSetup}">
<f:param name="id" value="#{item.id}"/>
</h:commandLink>
 </h:column>
</h:dataTable>
</h:panelGroup>
<br />
<h:commandLink action="#{users.createSetup}" value="New Users"/>
<br />
<a href="/Reno/index.jsp">Back to index</a>

</h:form>
</f:view>
</body>
</html>
