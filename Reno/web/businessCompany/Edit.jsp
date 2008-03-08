<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Edit BusinessCompany</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>Edit BusinessCompany</h1>
<h:form>
  <h:inputHidden value="#{businessCompany.businessCompany}" immediate="true"/>
<h:panelGrid columns="2">
<h:outputText value="Id:"/>
 <h:outputText value="#{businessCompany.businessCompany.id}" title="Id" />
<h:outputText value="Name:"/>
 <h:inputText id="name" value="#{businessCompany.businessCompany.name}" title="Name" />
<h:outputText value="OfficePhone:"/>
 <h:inputText id="officePhone" value="#{businessCompany.businessCompany.officePhone}" title="OfficePhone" />
<h:outputText value="Fax:"/>
 <h:inputText id="fax" value="#{businessCompany.businessCompany.fax}" title="Fax" />
<h:outputText value="Address:"/>
 <h:inputText id="address" value="#{businessCompany.businessCompany.address}" title="Address" />
<h:outputText value="MobilePhone:"/>
 <h:inputText id="mobilePhone" value="#{businessCompany.businessCompany.mobilePhone}" title="MobilePhone" />
<h:outputText value="Project:"/>
 <h:selectOneMenu id="project" value="#{businessCompany.businessCompany.project}" title="Project">
 <f:selectItems value="#{businessCompany.projects}"/>
 </h:selectOneMenu>
</h:panelGrid>
<br />
<h:commandLink action="#{businessCompany.edit}" value="Save"/>
<br />
<h:commandLink action="businessCompany_list" value="Show All BusinessCompany"/>
<br />
<a href="/Reno/index.jsp">Back to index</a>
</h:form>
 </f:view>
</body>
</html>
