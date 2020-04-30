<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/admin/common/init.jsp" %>

<%
KBAdminNavigationDisplayContext kbAdminNavigationDisplayContext = new KBAdminNavigationDisplayContext(request, liferayPortletResponse);
%>

<clay:navigation-bar
	inverted="<%= true %>"
	navigationItems="<%= kbAdminNavigationDisplayContext.getNavigationItems() %>"
/>