<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/definition_link/init.jsp" %>

<clay:management-toolbar
	clearResultsURL="<%= workflowDefinitionLinkDisplayContext.getClearResultsURL() %>"
	filterDropdownItems="<%= workflowDefinitionLinkDisplayContext.getFilterOptions(request) %>"
	itemsTotal="<%= workflowDefinitionLinkDisplayContext.getTotalItems() %>"
	namespace="<%= renderResponse.getNamespace() %>"
	searchActionURL="<%= workflowDefinitionLinkDisplayContext.getSearchURL() %>"
	searchContainerId="workflowDefinitionLinks"
	searchFormName="fm1"
	selectable="false"
	sortingOrder="<%= workflowDefinitionLinkDisplayContext.getOrderByType() %>"
	sortingURL="<%= workflowDefinitionLinkDisplayContext.getSortingURL() %>"
/>