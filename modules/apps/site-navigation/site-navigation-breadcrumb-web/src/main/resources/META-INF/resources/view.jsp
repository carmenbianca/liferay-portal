<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<liferay-ui:breadcrumb
	ddmTemplateGroupId="<%= siteNavigationBreadcrumbDisplayContext.getDisplayStyleGroupId() %>"
	ddmTemplateKey="<%= siteNavigationBreadcrumbDisplayContext.getDDMTemplateKey() %>"
	showCurrentGroup="<%= siteNavigationBreadcrumbDisplayContext.isShowCurrentGroup() %>"
	showGuestGroup="<%= siteNavigationBreadcrumbDisplayContext.isShowGuestGroup() %>"
	showLayout="<%= siteNavigationBreadcrumbDisplayContext.isShowLayout() %>"
	showParentGroups="<%= siteNavigationBreadcrumbDisplayContext.isShowParentGroups() %>"
	showPortletBreadcrumb="<%= siteNavigationBreadcrumbDisplayContext.isShowPortletBreadcrumb() %>"
/>