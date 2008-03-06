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
<h:outputText value="PaymentDate:"/>
 <h:inputText id="paymentDate" value="#{payment.payment.paymentDate}" title="PaymentDate" />
<h:outputText value="Comment:"/>
 <h:inputText id="comment" value="#{payment.payment.comment}" title="Comment" />
<h:outputText value="Task:" rendered="#{payment.payment.task == null}"/>
 <h:selectOneMenu id="task" value="#{payment.payment.task}" title="Task" rendered="#{payment.payment.task == null}">
 <f:selectItems value="#{payment.tasks}"/>
 </h:selectOneMenu>
<h:outputText value="PaidTo:" rendered="#{payment.payment.paidTo == null}"/>
 <h:selectOneMenu id="paidTo" value="#{payment.payment.paidTo}" title="PaidTo" rendered="#{payment.payment.paidTo == null}">
 <f:selectItems value="#{payment.paidTos}"/>
 </h:selectOneMenu>
<h:outputText value="PaymentType:" rendered="#{payment.payment.paymentType == null}"/>
 <h:selectOneMenu id="paymentType" value="#{payment.payment.paymentType}" title="PaymentType" rendered="#{payment.payment.paymentType == null}">
 <f:selectItems value="#{payment.paymentTypes}"/>
 </h:selectOneMenu>
<h:outputText value="PercentageTaskCompleted:" rendered="#{payment.payment.percentageTaskCompleted == null}"/>
 <h:selectOneMenu id="percentageTaskCompleted" value="#{payment.payment.percentageTaskCompleted}" title="PercentageTaskCompleted" rendered="#{payment.payment.percentageTaskCompleted == null}">
 <f:selectItems value="#{payment.percentageTaskCompleteds}"/>
 </h:selectOneMenu>
</h:panelGrid>
<br />
<h:commandLink action="#{payment.createFromTask}" value="Create" rendered="#{payment.payment.task != null and payment.payment.paidTo == null and payment.payment.paymentType == null and payment.payment.percentageTaskCompleted == null}"/>
<h:commandLink action="#{payment.createFromUsers}" value="Create" rendered="#{payment.payment.paidTo != null and payment.payment.task == null and payment.payment.paymentType == null and payment.payment.percentageTaskCompleted == null}"/>
<h:commandLink action="#{payment.createFromPaymentTypes}" value="Create" rendered="#{payment.payment.paymentType != null and payment.payment.task == null and payment.payment.paidTo == null and payment.payment.percentageTaskCompleted == null}"/>
<h:commandLink action="#{payment.createFromPercentageValues}" value="Create" rendered="#{payment.payment.percentageTaskCompleted != null and payment.payment.task == null and payment.payment.paidTo == null and payment.payment.paymentType == null}"/>
<h:commandLink action="#{payment.create}" value="Create" rendered="#{payment.payment.task == null and payment.payment.paidTo == null and payment.payment.paymentType == null and payment.payment.percentageTaskCompleted == null}"/>
<br />
<h:commandLink action="payment_list" value="Show All Payment"/>
 <br />
<a href="/WebApplication15/index.jsp">Back to index</a>
</h:form>
 </f:view>
</body>
</html>
