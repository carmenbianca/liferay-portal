<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<div class="sheet">
	<h2 class="sheet-title">
		<liferay-ui:message key="unable-to-sign-in-using-this-google-account" />
	</h2>

	<liferay-ui:error exception="<%= Exception.class %>" message="there-was-an-unknown-error" />
	<liferay-ui:error exception="<%= StrangersNotAllowedException.class %>" message="only-registered-users-are-allowed-to-sign-in-using-google" />
	<liferay-ui:error exception="<%= UserEmailAddressException.MustNotUseCompanyMx.class %>" message="this-google-account-cannot-be-used-to-register-a-new-user-because-its-email-domain-is-reserved" />

	<aui:button-row>
		<aui:button onClick="window.close();" value="close" />
	</aui:button-row>
</div>