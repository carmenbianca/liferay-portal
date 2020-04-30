<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
Map<String, Object> contextObjects = HashMapBuilder.<String, Object>put(
	"siteNavigationSiteMapDisplayContext", siteNavigationSiteMapDisplayContext
).build();
%>

<liferay-ddm:template-renderer
	className="<%= LayoutSet.class.getName() %>"
	contextObjects="<%= contextObjects %>"
	displayStyle="<%= siteNavigationSiteMapPortletInstanceConfiguration.displayStyle() %>"
	displayStyleGroupId="<%= siteNavigationSiteMapDisplayContext.getDisplayStyleGroupId() %>"
	entries="<%= siteNavigationSiteMapDisplayContext.getRootLayouts() %>"
>
	<%= siteNavigationSiteMapDisplayContext.buildSiteMap() %>
</liferay-ddm:template-renderer>