<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Edit Payment</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>Edit Payment</h1>
<h:form>
  <h:inputHidden value="#{payment.payment}" immediate="true"/>
<h:panelGrid columns="2">
<h:outputText value="Id:"/>
 <h:outputText value="#{payment.payment.id}" title="Id" />
<h:outputText value="Amount:"/>
 <h:inputText id="amount" value="#{payment.payment.amount}" title="Amount" />
<h:outputText value="Comment:"/>
 <h:inputText id="comment" value="#{payment.payment.comment}" title="Comment" />
<h:outputText value="Date:"/>
 <h:inputText id="date" value="#{payment.payment.date}" title="Date" />
<h:outputText value="PaymentType:"/>
 <h:selectOneMenu id="paymentType" value="#{payment.payment.paymentType}" title="PaymentType">
 <f:selectItems value="#{payment.paymentTypes}"/>
 </h:selectOneMenu>
<h:outputText value="PercentageTaskCompleted:"/>
 <h:selectOneMenu id="percentageTaskCompleted" value="#{payment.payment.percentageTaskCompleted}" title="PercentageTaskCompleted">
 <f:selectItems value="#{payment.percentageTaskCompleteds}"/>
 </h:selectOneMenu>
<h:outputText value="Task:"/>
 <h:selectOneMenu id="task" value="#{payment.payment.task}" title="Task">
 <f:selectItems value="#{payment.tasks}"/>
 </h:selectOneMenu>
<h:outputText value="PaidToUser:"/>
 <h:selectOneMenu id="paidToUser" value="#{payment.payment.paidToUser}" title="PaidToUser">
 <f:selectItems value="#{payment.paidToUsers}"/>
 </h:selectOneMenu>
<h:outputText value="PaidToBusiness:"/>
 <h:selectOneMenu id="paidToBusiness" value="#{payment.payment.paidToBusiness}" title="PaidToBusiness">
 <f:selectItems value="#{payment.paidToBusinesss}"/>
 </h:selectOneMenu>
</h:panelGrid>
<br />
<h:commandLink action="#{payment.edit}" value="Save"/>
<br />
<h:commandLink action="payment_list" value="Show All Payment"/>
<br />
<a href="/Reno/index.jsp">Back to index</a>
</h:form>
 </f:view>
</body>
</html>