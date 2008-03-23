<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Detail of Payment</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>Detail of Payment</h1>
<h:form>
  <h:panelGrid columns="2">
<h:outputText value="Id:"/>
 <h:outputText value="#{payment.payment.id}" title="Id" />
<h:outputText value="Amount:"/>
 <h:outputText value="#{payment.payment.amount}" title="Amount" />
<h:outputText value="Comment:"/>
 <h:outputText value="#{payment.payment.comment}" title="Comment" />
<h:outputText value="Date:"/>
 <h:outputText value="#{payment.payment.date}" title="Date" />
<h:outputText value="PaymentType:"/>
 <h:outputText value="#{payment.payment.paymentType}" title="PaymentType" />
<h:outputText value="PercentageTaskCompleted:"/>
 <h:outputText value="#{payment.payment.percentageTaskCompleted}" title="PercentageTaskCompleted" />
<h:outputText value="Task:"/>
 <h:outputText value="#{payment.payment.task}" title="Task" />
<h:outputText value="PaidToUser:"/>
 <h:outputText value="#{payment.payment.paidToUser}" title="PaidToUser" />
<h:outputText value="PaidToBusiness:"/>
 <h:outputText value="#{payment.payment.paidToBusiness}" title="PaidToBusiness" />
</h:panelGrid>
<br />
<h:commandLink action="payment_edit" value="Edit" />
<br>
<h:commandLink action="payment_list" value="Show All Payment"/>
<br />
<a href="/Reno/index.jsp">Back to index</a>
</h:form>
 </f:view>
</body>
</html>