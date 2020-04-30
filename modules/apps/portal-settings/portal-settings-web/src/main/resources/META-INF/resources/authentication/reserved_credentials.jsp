<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String adminReservedScreenNames = PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.ADMIN_RESERVED_SCREEN_NAMES);
String adminReservedEmailAddresses = PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.ADMIN_RESERVED_EMAIL_ADDRESSES);
%>

<aui:fieldset>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />

	<aui:input helpMessage="enter-one-screen-name-per-line-to-reserve-the-screen-name" label="screen-names" name='<%= "settings--" + PropsKeys.ADMIN_RESERVED_SCREEN_NAMES + "--" %>' type="textarea" value="<%= adminReservedScreenNames %>" />

	<aui:input helpMessage="enter-one-user-email-address-per-line-to-reserve-the-user-email-address" label="email-addresses" name='<%= "settings--" + PropsKeys.ADMIN_RESERVED_EMAIL_ADDRESSES + "--" %>' type="textarea" value="<%= adminReservedEmailAddresses %>" />
</aui:fieldset>