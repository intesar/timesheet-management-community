<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>List UserInvestment</title>
</head>
<body>
<f:view>
  <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
 <h1>Listing UserInvestments</h1>
<h:form>
<h:outputText escape="false" value="(No UserInvestments Found)<br />" rendered="#{userInvestment.itemCount == 0}" />
<h:panelGroup rendered="#{userInvestment.itemCount > 0}">
<h:outputText value="Item #{userInvestment.firstItem + 1}..#{userInvestment.lastItem} of #{userInvestment.itemCount}"/>&nbsp;
<h:commandLink action="#{userInvestment.prev}" value="Previous #{userInvestment.batchSize}" rendered="#{userInvestment.firstItem >= userInvestment.batchSize}"/>&nbsp;
<h:commandLink action="#{userInvestment.next}" value="Next #{userInvestment.batchSize}" rendered="#{userInvestment.lastItem + userInvestment.batchSize <= userInvestment.itemCount}"/>&nbsp;
<h:commandLink action="#{userInvestment.next}" value="Remaining #{userInvestment.itemCount - userInvestment.lastItem}"
rendered="#{userInvestment.lastItem < userInvestment.itemCount && userInvestment.lastItem + userInvestment.batchSize > userInvestment.itemCount}"/>
<h:dataTable value='#{userInvestment.userInvestments}' var='item' border="1" cellpadding="2" cellspacing="0">
<h:column>
 <f:facet name="header">
 <h:outputText value="Id"/>
 </f:facet>
<h:commandLink action="#{userInvestment.detailSetup}" value="#{item.id}"/>
 </h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="Amount"/>
 </f:facet>
 <h:outputText value="#{item.amount}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="TransactionDate"/>
 </f:facet>
 <h:outputText value="#{item.transactionDate}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="Comment"/>
 </f:facet>
 <h:outputText value="#{item.comment}"/>
</h:column>
<h:column>
 <f:facet name="header">
 <h:outputText value="UserId"/>
 </f:facet>
 <h:outputText value="#{item.userId}"/>
</h:column>
<h:column>
 <h:commandLink value="Destroy" action="#{userInvestment.destroy}">
<f:param name="id" value="#{item.id}"/>
</h:commandLink>
  <h:outputText value=" "/>
 <h:commandLink value="Edit" action="#{userInvestment.editSetup}">
<f:param name="id" value="#{item.id}"/>
</h:commandLink>
 </h:column>
</h:dataTable>
</h:panelGroup>
<br />
<h:commandLink action="#{userInvestment.createSetup}" value="New UserInvestment"/>
<br />
<a href="/WebApplication15/index.jsp">Back to index</a>

</h:form>
</f:view>
</body>
</html>
