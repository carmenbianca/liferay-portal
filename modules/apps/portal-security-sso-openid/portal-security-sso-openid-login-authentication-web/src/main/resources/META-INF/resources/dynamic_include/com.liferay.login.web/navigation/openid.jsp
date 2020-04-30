<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/dynamic_include/init.jsp" %>

<portlet:renderURL var="openIdURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
	<portlet:param name="mvcRenderCommandName" value="/login/openid" />
</portlet:renderURL>

<liferay-ui:icon
	message="openid"
	url="<%= openIdURL %>"
/>