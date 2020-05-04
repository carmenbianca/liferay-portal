<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String loanAmountString = ParamUtil.get(request, "loanAmount", "200000");
double interestRate = ParamUtil.get(request, "interestRate", 7.00);
float years = ParamUtil.get(request, "years", 30F);
int paymentsPerYear = ParamUtil.get(request, "paymentsPerYear", 12);

int loanAmount = 0;

NumberFormat doubleFormat = NumberFormat.getNumberInstance(locale);

doubleFormat.setMaximumFractionDigits(2);
doubleFormat.setMinimumFractionDigits(2);

NumberFormat integerFormat = NumberFormat.getNumberInstance(locale);

integerFormat.setMaximumFractionDigits(0);
integerFormat.setMinimumFractionDigits(0);

try {
	loanAmount = GetterUtil.getInteger(integerFormat.parse(loanAmountString));
}
catch (Exception e) {
}

double tempValue = Math.pow(1 + (interestRate / 100 / paymentsPerYear), years * paymentsPerYear);

double amountPerPayment = (loanAmount * tempValue * (interestRate / 100 / paymentsPerYear)) / (tempValue - 1);

double totalPaid = amountPerPayment * years * paymentsPerYear;

double interestPaid = totalPaid - loanAmount;
%>

<portlet:renderURL var="viewLoanURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="struts_action" value="/loan_calculator/view" />
</portlet:renderURL>

<aui:form action="<%= viewLoanURL %>" id="fm" method="post" name="fm">
	<aui:row>
		<aui:col width="<%= 50 %>">
			<aui:fieldset>
				<aui:field-wrapper>
					<aui:input autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) %>" name="loanAmount" value="<%= integerFormat.format(loanAmount) %>" />

					<aui:input name="interestRate" value="<%= doubleFormat.format(interestRate) %>" />

					<aui:input name="years" value="<%= years %>" />

					<aui:button-row>
						<aui:button type="submit" value="calculate" />
					</aui:button-row>
				</aui:field-wrapper>
			</aui:fieldset>
		</aui:col>

		<aui:col width="<%= 50 %>">
			<aui:fieldset>
				<aui:field-wrapper>
					<aui:input disabled="<%= true %>" name="monthlyPayment" value="<%= integerFormat.format(amountPerPayment) %>" />

					<aui:input disabled="<%= true %>" name="interestPaid" value="<%= integerFormat.format(interestPaid) %>" />

					<aui:input disabled="<%= true %>" name="totalPaid" value="<%= integerFormat.format(totalPaid) %>" />
				</aui:field-wrapper>
			</aui:fieldset>
		</aui:col>
	</aui:row>
</aui:form>

<aui:script use="aui-io-request,aui-parse-content">
	var form = A.one('#<portlet:namespace />fm');
	var parentNode = form.get('parentNode');

	parentNode.plug(A.Plugin.ParseContent);

	form.on('submit', function(event) {
		var uri = form.getAttribute('action');

		A.io.request(uri, {
			form: {
				id: form,
			},
			on: {
				success: function(event, id, obj) {
					var responseData = this.get('responseData');

					parentNode.setContent(responseData);
				},
			},
		});

		event.halt();
	});
</aui:script>