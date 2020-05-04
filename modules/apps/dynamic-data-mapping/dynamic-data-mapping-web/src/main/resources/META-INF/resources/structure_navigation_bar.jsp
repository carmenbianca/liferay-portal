<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
List<NavigationItem> navigationItems = ddmDisplayContext.getNavigationItem();
%>

<c:if test="<%= navigationItems.size() > 1 %>">
	<clay:navigation-bar
		inverted="<%= true %>"
		navigationItems="<%= navigationItems %>"
	/>
</c:if>