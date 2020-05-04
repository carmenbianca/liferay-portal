<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/dynamic_include/init.jsp" %>

<%
String openSSOSubjectScreenName = (String)request.getAttribute(OpenSSOWebKeys.OPEN_SSO_SUBJECT_SCREEN_NAME);
%>

<liferay-util:buffer
	var="msg"
>
	<liferay-ui:message arguments='<%= "<strong>" + HtmlUtil.escape(openSSOSubjectScreenName) + "</strong>" %>' key="your-user-x-could-not-be-logged-in" />

	<c:choose>
		<c:when test='<%= SessionMessages.contains(request, "MustNotUseCompanyMx") %>'>
			<liferay-ui:message key="the-email-address-associated-with-your-opensso-account-cannot-be-used-to-register-a-new-user-because-its-email-domain-is-reserved" />
		</c:when>
		<c:when test='<%= SessionMessages.contains(request, "StrangersNotAllowedException") %>'>
			<liferay-ui:message key="only-known-users-are-allowed-to-sign-in-using-opensso" />
		</c:when>
		<c:when test='<%= SessionMessages.contains(request, "ContactNameException") %>'>
			<liferay-ui:message key="your-contact-name-is-incomplete-or-invalid" />
		</c:when>
	</c:choose>

	<a href="<%= themeDisplay.getURLSignOut() %>"><liferay-ui:message arguments='<%= "<strong>" + HtmlUtil.escapeAttribute(openSSOSubjectScreenName) + "</strong>" %>' key="not-x" /></a>
</liferay-util:buffer>

<script type="text/javascript">
	AUI().use('liferay-notification', function(A) {
		new Liferay.Notification({
			closeable: true,
			delay: {
				hide: 10000,
				show: 0,
			},
			duration: 500,
			message: '<%= HtmlUtil.escapeJS(msg) %>',
			render: true,
			title: '<liferay-ui:message key="warning" />',
			type: 'warning',
		}).render('body');
	});
</script>