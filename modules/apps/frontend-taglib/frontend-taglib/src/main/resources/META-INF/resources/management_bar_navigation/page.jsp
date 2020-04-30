<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/management_bar_navigation/init.jsp" %>

<%
boolean disabled = GetterUtil.getBoolean(request.getAttribute("liferay-frontend:management-bar-navigation:disabled"));
List<ManagementBarFilterItem> managementBarFilterItems = (List<ManagementBarFilterItem>)request.getAttribute("liferay-frontend:management-bar-navigation:managementBarFilterItems");
String label = (String)request.getAttribute("liferay-frontend:management-bar-navigation:label");
%>

<liferay-frontend:management-bar-filter
	disabled="<%= disabled %>"
	managementBarFilterItems="<%= managementBarFilterItems %>"
	value="<%= label %>"
/>