<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String companySecurityAuthType = company.getAuthType();
boolean companySecurityAutoLogin = company.isAutoLogin();
boolean companySecuritySendPasswordResetLink = company.isSendPasswordResetLink();
boolean companySecurityStrangers = company.isStrangers();
boolean companySecurityStrangersWithMx = company.isStrangersWithMx();
boolean companySecurityStrangersVerify = company.isStrangersVerify();
%>

<aui:fieldset>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />

	<aui:select label="how-do-users-authenticate" name='<%= "settings--" + PropsKeys.COMPANY_SECURITY_AUTH_TYPE + "--" %>' value="<%= companySecurityAuthType %>">
		<aui:option label="by-email-address" value="<%= CompanyConstants.AUTH_TYPE_EA %>" />
		<aui:option label="by-screen-name" value="<%= CompanyConstants.AUTH_TYPE_SN %>" />
		<aui:option label="by-user-id" value="<%= CompanyConstants.AUTH_TYPE_ID %>" />
	</aui:select>

	<aui:input label="allow-users-to-automatically-log-in" name='<%= "settings--" + PropsKeys.COMPANY_SECURITY_AUTO_LOGIN + "--" %>' type="checkbox" value="<%= companySecurityAutoLogin %>" />

	<aui:input helpMessage="allow-users-to-request-password-reset-links-help" label="allow-users-to-request-password-reset-links" name='<%= "settings--" + PropsKeys.COMPANY_SECURITY_SEND_PASSWORD_RESET_LINK + "--" %>' type="checkbox" value="<%= companySecuritySendPasswordResetLink %>" />

	<aui:input label="allow-strangers-to-create-accounts" name='<%= "settings--" + PropsKeys.COMPANY_SECURITY_STRANGERS + "--" %>' type="checkbox" value="<%= companySecurityStrangers %>" />

	<aui:input label="allow-strangers-to-create-accounts-with-a-company-email-address" name='<%= "settings--" + PropsKeys.COMPANY_SECURITY_STRANGERS_WITH_MX + "--" %>' type="checkbox" value="<%= companySecurityStrangersWithMx %>" />

	<aui:input helpMessage="require-strangers-to-verify-their-email-address-help" label="require-strangers-to-verify-their-email-address" name='<%= "settings--" + PropsKeys.COMPANY_SECURITY_STRANGERS_VERIFY + "--" %>' type="checkbox" value="<%= companySecurityStrangersVerify %>" />
</aui:fieldset>