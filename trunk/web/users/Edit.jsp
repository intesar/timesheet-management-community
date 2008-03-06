<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Edit Users</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>Edit Users</h1>
<h:form>
  <h:inputHidden value="#{users.users}" immediate="true"/>
<h:panelGrid columns="2">
<h:outputText value="Id:"/>
 <h:outputText value="#{users.users.id}" title="Id" />
<h:outputText value="Firstname:"/>
 <h:inputText id="firstname" value="#{users.users.firstname}" title="Firstname" />
<h:outputText value="Lastname:"/>
 <h:inputText id="lastname" value="#{users.users.lastname}" title="Lastname" />
<h:outputText value="Email:"/>
 <h:inputText id="email" value="#{users.users.email}" title="Email" />
<h:outputText value="OfficePhone:"/>
 <h:inputText id="officePhone" value="#{users.users.officePhone}" title="OfficePhone" />
<h:outputText value="MobilePhone:"/>
 <h:inputText id="mobilePhone" value="#{users.users.mobilePhone}" title="MobilePhone" />
<h:outputText value="Fax:"/>
 <h:inputText id="fax" value="#{users.users.fax}" title="Fax" />
<h:outputText value="OtherPhone:"/>
 <h:inputText id="otherPhone" value="#{users.users.otherPhone}" title="OtherPhone" />
</h:panelGrid>
<br />
<h:commandLink action="#{users.edit}" value="Save"/>
<br />
<h:commandLink action="users_list" value="Show All Users"/>
<br />
<a href="/WebApplication15/index.jsp">Back to index</a>
</h:form>
 </f:view>
</body>
</html>
