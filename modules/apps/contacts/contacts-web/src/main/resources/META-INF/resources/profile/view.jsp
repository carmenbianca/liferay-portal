<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<c:choose>
	<c:when test="<%= scopeGroup.isUser() %>">

		<%
		User user2 = UserLocalServiceUtil.getUserById(scopeGroup.getClassPK());

		request.setAttribute(ContactsWebKeys.CONTACTS_USER, user2);
		%>

		<aui:row>
			<aui:col cssClass="contacts-container" width="<%= 100 %>">
				<liferay-util:include page="/view_user.jsp" servletContext="<%= application %>" />
			</aui:col>
		</aui:row>
	</c:when>
	<c:otherwise>
		<div class="lfr-message-info">
			<liferay-ui:message key="this-application-only-functions-when-placed-on-a-user-page" />
		</div>
	</c:otherwise>
</c:choose>