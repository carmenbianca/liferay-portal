<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String adminEmailFromName = PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
String adminEmailFromAddress = PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
%>

<aui:fieldset>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />

	<liferay-ui:error key="emailFromName" message="please-enter-a-valid-name" />

	<aui:input cssClass="lfr-input-text-container" label="name" name='<%= "settings--" + PropsKeys.ADMIN_EMAIL_FROM_NAME + "--" %>' type="text" value="<%= adminEmailFromName %>" />

	<liferay-ui:error exception="<%= EmailAddressException.class %>" message="please-enter-a-valid-email-address" />

	<aui:input cssClass="lfr-input-text-container" label="address" name='<%= "settings--" + PropsKeys.ADMIN_EMAIL_FROM_ADDRESS + "--" %>' type="text" value="<%= adminEmailFromAddress %>">
		<aui:validator name="email" />
	</aui:input>
</aui:fieldset>