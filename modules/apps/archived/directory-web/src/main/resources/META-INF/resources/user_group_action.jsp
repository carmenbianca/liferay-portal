<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

UserGroup userGroup = (UserGroup)row.getObject();
%>

<portlet:renderURL var="viewUsersURL">
	<portlet:param name="mvcRenderCommandName" value="/directory/view" />
	<portlet:param name="tabs1" value="users" />
	<portlet:param name="viewUsersRedirect" value="<%= currentURL %>" />
	<portlet:param name="userGroupId" value="<%= String.valueOf(userGroup.getUserGroupId()) %>" />
</portlet:renderURL>

<liferay-ui:icon
	icon="users"
	markupView="lexicon"
	message="view-users"
	method="get"
	url="<%= viewUsersURL %>"
/>