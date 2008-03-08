<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>New Payment</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>New Payment</h1>
<h:form>
  <h:panelGrid columns="2">
<h:outputText value="Id:"/>
 <h:inputText id="id" value="#{payment.payment.id}" title="Id" />
<h:outputText value="Amount:"/>
 <h:inputText id="amount" value="#{payment.payment.amount}" title="Amount" />
<h:outputText value="Comment:"/>
 <h:inputText id="comment" value="#{payment.payment.comment}" title="Comment" />
<h:outputText value="Date:"/>
 <h:inputText id="date" value="#{payment.payment.date}" title="Date" />
<h:outputText value="PaymentType:" rendered="#{payment.payment.paymentType == null}"/>
 <h:selectOneMenu id="paymentType" value="#{payment.payment.paymentType}" title="PaymentType" rendered="#{payment.payment.paymentType == null}">
 <f:selectItems value="#{payment.paymentTypes}"/>
 </h:selectOneMenu>
<h:outputText value="PercentageTaskCompleted:" rendered="#{payment.payment.percentageTaskCompleted == null}"/>
 <h:selectOneMenu id="percentageTaskCompleted" value="#{payment.payment.percentageTaskCompleted}" title="PercentageTaskCompleted" rendered="#{payment.payment.percentageTaskCompleted == null}">
 <f:selectItems value="#{payment.percentageTaskCompleteds}"/>
 </h:selectOneMenu>
<h:outputText value="Task:" rendered="#{payment.payment.task == null}"/>
 <h:selectOneMenu id="task" value="#{payment.payment.task}" title="Task" rendered="#{payment.payment.task == null}">
 <f:selectItems value="#{payment.tasks}"/>
 </h:selectOneMenu>
<h:outputText value="PaidToUser:" rendered="#{payment.payment.paidToUser == null}"/>
 <h:selectOneMenu id="paidToUser" value="#{payment.payment.paidToUser}" title="PaidToUser" rendered="#{payment.payment.paidToUser == null}">
 <f:selectItems value="#{payment.paidToUsers}"/>
 </h:selectOneMenu>
<h:outputText value="PaidToBusiness:" rendered="#{payment.payment.paidToBusiness == null}"/>
 <h:selectOneMenu id="paidToBusiness" value="#{payment.payment.paidToBusiness}" title="PaidToBusiness" rendered="#{payment.payment.paidToBusiness == null}">
 <f:selectItems value="#{payment.paidToBusinesss}"/>
 </h:selectOneMenu>
</h:panelGrid>
<br />
<h:commandLink action="#{payment.createFromPaymentTypes}" value="Create" rendered="#{payment.payment.paymentType != null and payment.payment.percentageTaskCompleted == null and payment.payment.task == null and payment.payment.paidToUser == null and payment.payment.paidToBusiness == null}"/>
<h:commandLink action="#{payment.createFromPercentageValues}" value="Create" rendered="#{payment.payment.percentageTaskCompleted != null and payment.payment.paymentType == null and payment.payment.task == null and payment.payment.paidToUser == null and payment.payment.paidToBusiness == null}"/>
<h:commandLink action="#{payment.createFromTask}" value="Create" rendered="#{payment.payment.task != null and payment.payment.paymentType == null and payment.payment.percentageTaskCompleted == null and payment.payment.paidToUser == null and payment.payment.paidToBusiness == null}"/>
<h:commandLink action="#{payment.createFromUsers}" value="Create" rendered="#{payment.payment.paidToUser != null and payment.payment.paymentType == null and payment.payment.percentageTaskCompleted == null and payment.payment.task == null and payment.payment.paidToBusiness == null}"/>
<h:commandLink action="#{payment.createFromBusinessCompany}" value="Create" rendered="#{payment.payment.paidToBusiness != null and payment.payment.paymentType == null and payment.payment.percentageTaskCompleted == null and payment.payment.task == null and payment.payment.paidToUser == null}"/>
<h:commandLink action="#{payment.create}" value="Create" rendered="#{payment.payment.paymentType == null and payment.payment.percentageTaskCompleted == null and payment.payment.task == null and payment.payment.paidToUser == null and payment.payment.paidToBusiness == null}"/>
<br />
<h:commandLink action="payment_list" value="Show All Payment"/>
 <br />
<a href="/Reno/index.jsp">Back to index</a>
</h:form>
 </f:view>
</body>
</html>
