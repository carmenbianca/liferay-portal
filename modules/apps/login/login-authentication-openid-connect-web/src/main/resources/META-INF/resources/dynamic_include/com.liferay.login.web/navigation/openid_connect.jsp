<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/dynamic_include/init.jsp" %>

<%
String redirect = ParamUtil.getString(renderRequest, "redirect");
%>

<portlet:renderURL var="openIdConnectURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
	<portlet:param name="saveLastPath" value="<%= Boolean.FALSE.toString() %>" />
	<portlet:param name="mvcRenderCommandName" value="<%= OpenIdConnectWebKeys.OPEN_ID_CONNECT_REQUEST_ACTION_NAME %>" />
	<portlet:param name="redirect" value="<%= redirect %>" />
</portlet:renderURL>

<liferay-ui:icon
	message="openid-connect"
	url="<%= openIdConnectURL %>"
/>