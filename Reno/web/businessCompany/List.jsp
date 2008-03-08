<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>List BusinessCompany</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>Listing BusinessCompanys</h1>
<h:form>
<h:outputText escape="false" value="(No BusinessCompanys Found)<br />" rendered="#{businessCompany.itemCount == 0}" />
<h:panelGroup rendered="#{businessCompany.itemCount > 0}">
<h:outputText value="Item #{businessCompany.firstItem + 1}..#{businessCompany.lastItem} of #{businessCompany.itemCount}"/>&nbsp;
<h:commandLink action="#{businessCompany.prev}" value="Previous #{businessCompany.batchSize}" rendered="#{businessCompany.firstItem >= businessCompany.batchSize}"/>&nbsp;
<h:commandLink action="#{businessCompany.next}" value="Next #{businessCompany.batchSize}" rendered="#{businessCompany.lastItem + businessCompany.batchSize <= businessCompany.itemCount}"/>&nbsp;
<h:commandLink action="#{businessCompany.next}" value="Remaining #{businessCompany.itemCount - businessCompany.lastItem}"
rendered="#{businessCompany.lastItem < businessCompany.itemCount && businessCompany.lastItem + businessCompany.batchSize > businessCompany.itemCount}"/>
<h:dataTable value='#{businessCompany.businessCompanys}' var='item' border="1" cellpadding="2" cellspacing="0">
<h:column>
 <f:facet name="header">
 <h:outputText value="Id"/>
 </f:facet>
<h:commandLink action="#{businessCompany.detailSetup}" value="#{item.id}"/>
 </h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="Name"/>
 </f:facet>
 <h:outputText value="#{item.name}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="OfficePhone"/>
 </f:facet>
 <h:outputText value="#{item.officePhone}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="Fax"/>
 </f:facet>
 <h:outputText value="#{item.fax}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="Address"/>
 </f:facet>
 <h:outputText value="#{item.address}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="MobilePhone"/>
 </f:facet>
 <h:outputText value="#{item.mobilePhone}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="Project"/>
 </f:facet>
 <h:outputText value="#{item.project}"/>
</h:column>
<h:column>
 <h:commandLink value="Destroy" action="#{businessCompany.destroy}">
<f:param name="id" value="#{item.id}"/>
</h:commandLink>
  <h:outputText value=" "/>
 <h:commandLink value="Edit" action="#{businessCompany.editSetup}">
<f:param name="id" value="#{item.id}"/>
</h:commandLink>
 </h:column>
</h:dataTable>
</h:panelGroup>
<br />
<h:commandLink action="#{businessCompany.createSetup}" value="New BusinessCompany"/>
<br />
<a href="/Reno/index.jsp">Back to index</a>

</h:form>
</f:view>
</body>
</html>
