<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
long liveGroupId = ParamUtil.getLong(request, "liveGroupId");
boolean privateLayout = ParamUtil.getBoolean(request, "privateLayout");
String displayStyle = ParamUtil.getString(request, "displayStyle", "descriptive");
String navigation = ParamUtil.getString(request, "navigation", "all");
String orderByCol = ParamUtil.getString(request, "orderByCol");
String orderByType = ParamUtil.getString(request, "orderByType");
String searchContainerId = ParamUtil.getString(request, "searchContainerId");
%>

<div id="<portlet:namespace />exportProcessesSearchContainer">
	<div class="container-fluid-1280" id="<portlet:namespace />processesContainer">
		<liferay-util:include page="/export/processes_list/export_layouts_processes.jsp" servletContext="<%= application %>">
			<liferay-util:param name="groupId" value="<%= String.valueOf(liveGroupId) %>" />
			<liferay-util:param name="privateLayout" value="<%= String.valueOf(privateLayout) %>" />
			<liferay-util:param name="displayStyle" value="<%= displayStyle %>" />
			<liferay-util:param name="navigation" value="<%= navigation %>" />
			<liferay-util:param name="orderByCol" value="<%= orderByCol %>" />
			<liferay-util:param name="orderByType" value="<%= orderByType %>" />
			<liferay-util:param name="searchContainerId" value="<%= searchContainerId %>" />
		</liferay-util:include>
	</div>
</div>