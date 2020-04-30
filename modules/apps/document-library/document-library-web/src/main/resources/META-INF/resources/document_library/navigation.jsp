<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/document_library/init.jsp" %>

<%
DLAdminNavigationDisplayContext dlAdminNavigationDisplayContext = new DLAdminNavigationDisplayContext(liferayPortletRequest, liferayPortletResponse);
DLPortletInstanceSettingsHelper dlPortletInstanceSettingsHelper = new DLPortletInstanceSettingsHelper(dlRequestHelper);
%>

<c:if test="<%= dlPortletInstanceSettingsHelper.isShowTabs() %>">
	<clay:navigation-bar
		inverted="<%= true %>"
		navigationItems="<%= dlAdminNavigationDisplayContext.getNavigationItems() %>"
	/>
</c:if>