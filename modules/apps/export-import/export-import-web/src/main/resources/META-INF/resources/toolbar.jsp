<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
ExportImportToolbarDisplayContext exportImportToolbarDisplayContext = new ExportImportToolbarDisplayContext(request, liferayPortletResponse);
%>

<clay:management-toolbar
	actionDropdownItems="<%= exportImportToolbarDisplayContext.getActionDropdownItems() %>"
	creationMenu="<%= exportImportToolbarDisplayContext.getCreationMenu() %>"
	filterDropdownItems="<%= exportImportToolbarDisplayContext.getFilterDropdownItems() %>"
	searchContainerId="<%= exportImportToolbarDisplayContext.getSearchContainerId() %>"
	showCreationMenu="<%= true %>"
	showSearch="<%= false %>"
	sortingOrder="<%= exportImportToolbarDisplayContext.getSortingOrder() %>"
	sortingURL="<%= exportImportToolbarDisplayContext.getSortingURL() %>"
	viewTypeItems="<%= exportImportToolbarDisplayContext.getViewTypeItems() %>"
/>