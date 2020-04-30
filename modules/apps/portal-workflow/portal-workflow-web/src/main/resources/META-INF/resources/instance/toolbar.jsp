<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/instance/init.jsp" %>

<clay:management-toolbar
	clearResultsURL="<%= workflowInstanceViewDisplayContext.getClearResultsURL() %>"
	filterDropdownItems="<%= workflowInstanceViewDisplayContext.getFilterOptions(request) %>"
	itemsTotal="<%= workflowInstanceViewDisplayContext.getTotalItems() %>"
	namespace="<%= renderResponse.getNamespace() %>"
	searchActionURL="<%= workflowInstanceViewDisplayContext.getSearchURL() %>"
	searchContainerId="workflowInstance"
	searchFormName="fm1"
	selectable="<%= false %>"
	sortingOrder='<%= ParamUtil.getString(request, "orderByType", "asc") %>'
	sortingURL="<%= workflowInstanceViewDisplayContext.getSortingURL(request) %>"
	viewTypeItems="<%= workflowInstanceViewDisplayContext.getViewTypes() %>"
/>