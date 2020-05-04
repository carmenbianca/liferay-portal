<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Object[] objArray = (Object[])row.getObject();

Permission permission = (Permission)objArray[0];
Role role = (Role)objArray[1];
%>

<liferay-ui:icon-menu
	icon="<%= StringPool.BLANK %>"
	message="<%= StringPool.BLANK %>"
>
	<portlet:actionURL name="deletePermission" var="deletePermissionURL">
		<portlet:param name="mvcPath" value="/edit_role_permissions.jsp" />
		<portlet:param name="tabs1" value="define-permissions" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="roleId" value="<%= String.valueOf(role.getRoleId()) %>" />
		<portlet:param name="name" value="<%= permission.getName() %>" />
		<portlet:param name="scope" value="<%= String.valueOf(permission.getScope()) %>" />
		<portlet:param name="primKey" value="<%= permission.getPrimKey() %>" />
		<portlet:param name="actionId" value="<%= String.valueOf(permission.getActionId()) %>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete
		confirmation="are-you-sure-you-want-to-remove-this-permission"
		message="remove"
		url="<%= deletePermissionURL %>"
	/>
</liferay-ui:icon-menu>