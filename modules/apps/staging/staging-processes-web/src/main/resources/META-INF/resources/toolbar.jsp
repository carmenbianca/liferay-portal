<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String mvcRenderCommandName = ParamUtil.getString(request, "mvcRenderCommandName");

String tabs1 = ParamUtil.getString(request, "tabs1");

String displayStyle = ParamUtil.getString(request, "displayStyle", "descriptive");
String navigation = ParamUtil.getString(request, "navigation", "all");
String orderByCol = ParamUtil.getString(request, "orderByCol");
String orderByType = ParamUtil.getString(request, "orderByType");
String searchContainerId = ParamUtil.getString(request, "searchContainerId");

PortletURL portletURL = liferayPortletResponse.createRenderURL();

portletURL.setParameter("mvcRenderCommandName", mvcRenderCommandName);
portletURL.setParameter("tabs1", tabs1);
portletURL.setParameter("displayStyle", displayStyle);
portletURL.setParameter("navigation", navigation);
portletURL.setParameter("orderByCol", orderByCol);
portletURL.setParameter("orderByType", orderByType);
portletURL.setParameter("searchContainerId", String.valueOf(searchContainerId));
%>

<clay:management-toolbar
	actionDropdownItems="<%= stagingProcessesWebToolbarDisplayContext.getActionDropdownItems() %>"
	creationMenu="<%= stagingProcessesWebToolbarDisplayContext.getCreationMenu(GroupPermissionUtil.contains(permissionChecker, stagingGroupId, ActionKeys.PUBLISH_STAGING)) %>"
	filterDropdownItems="<%= stagingProcessesWebToolbarDisplayContext.getFilterDropdownItems() %>"
	searchContainerId="<%= searchContainerId %>"
	showCreationMenu='<%= tabs1.equals("processes") %>'
	showSearch="<%= false %>"
	sortingOrder="<%= stagingProcessesWebToolbarDisplayContext.getSortingOrder() %>"
	sortingURL="<%= stagingProcessesWebToolbarDisplayContext.getSortingURL() %>"
	viewTypeItems="<%= stagingProcessesWebToolbarDisplayContext.getViewTypeItems() %>"
/>