<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
Contact selContact = (Contact)request.getAttribute("user.selContact");
%>

<liferay-ui:error-marker
	key="<%= WebKeys.ERROR_SECTION %>"
	value="sms"
/>

<aui:model-context bean="<%= selContact %>" model="<%= Contact.class %>" />

<c:choose>
	<c:when test="<%= selContact != null %>">
		<liferay-ui:error exception="<%= UserSmsException.MustBeEmailAddress.class %>" message="please-enter-a-sms-id-that-is-a-valid-email-address" />

		<aui:input label="sms" name="smsSn" />
	</c:when>
	<c:otherwise>
		<clay:alert
			message='<%= LanguageUtil.get(request, "this-section-will-be-editable-after-creating-the-user") %>'
			style="info"
			title='<%= LanguageUtil.get(request, "info") + ":" %>'
		/>
	</c:otherwise>
</c:choose>