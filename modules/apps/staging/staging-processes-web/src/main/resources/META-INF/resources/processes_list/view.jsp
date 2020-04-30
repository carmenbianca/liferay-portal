<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String tabs1 = ParamUtil.getString(request, "tabs1");

String displayStyle = ParamUtil.getString(request, "displayStyle", "descriptive");
String navigation = ParamUtil.getString(request, "navigation", "all");
String orderByCol = ParamUtil.getString(request, "orderByCol");
String orderByType = ParamUtil.getString(request, "orderByType");
String searchContainerId = ParamUtil.getString(request, "searchContainerId");
%>

<liferay-ui:success key="localStagingEnabled" message="local-staging-is-successfully-enabled" />

<liferay-ui:success key="remoteStagingEnabled" message="remote-staging-is-successfully-enabled" />

<div id="<portlet:namespace />publishProcessesSearchContainer">
	<liferay-util:include page="/toolbar.jsp" servletContext="<%= application %>">
		<liferay-util:param name="mvcRenderCommandName" value="viewPublishLayouts" />
		<liferay-util:param name="tabs1" value="<%= tabs1 %>" />
		<liferay-util:param name="displayStyle" value="<%= displayStyle %>" />
		<liferay-util:param name="navigation" value="<%= navigation %>" />
		<liferay-util:param name="orderByCol" value="<%= orderByCol %>" />
		<liferay-util:param name="orderByType" value="<%= orderByType %>" />
		<liferay-util:param name="searchContainerId" value="<%= searchContainerId %>" />
	</liferay-util:include>

	<div class="container-fluid-1280" id="<portlet:namespace />processesContainer">
		<liferay-util:include page="/processes_list/publish_layouts_processes.jsp" servletContext="<%= application %>" />
	</div>
</div>