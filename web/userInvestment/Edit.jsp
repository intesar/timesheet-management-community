<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Edit UserInvestment</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>Edit UserInvestment</h1>
<h:form>
  <h:inputHidden value="#{userInvestment.userInvestment}" immediate="true"/>
<h:panelGrid columns="2">
<h:outputText value="Id:"/>
 <h:outputText value="#{userInvestment.userInvestment.id}" title="Id" />
<h:outputText value="Amount:"/>
 <h:inputText id="amount" value="#{userInvestment.userInvestment.amount}" title="Amount" />
<h:outputText value="TransactionDate:"/>
 <h:inputText id="transactionDate" value="#{userInvestment.userInvestment.transactionDate}" title="TransactionDate" />
<h:outputText value="Comment:"/>
 <h:inputText id="comment" value="#{userInvestment.userInvestment.comment}" title="Comment" />
<h:outputText value="UserId:"/>
 <h:selectOneMenu id="userId" value="#{userInvestment.userInvestment.userId}" title="UserId">
 <f:selectItems value="#{userInvestment.userIds}"/>
 </h:selectOneMenu>
</h:panelGrid>
<br />
<h:commandLink action="#{userInvestment.edit}" value="Save"/>
<br />
<h:commandLink action="userInvestment_list" value="Show All UserInvestment"/>
<br />
<a href="/WebApplication15/index.jsp">Back to index</a>
</h:form>
 </f:view>
</body>
</html>
