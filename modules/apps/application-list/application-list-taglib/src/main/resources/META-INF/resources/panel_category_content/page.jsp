<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/panel_category_content/init.jsp" %>

<%
PanelCategory panelCategory = (PanelCategory)request.getAttribute("liferay-application-list:panel-category-content:panelCategory");
boolean showOpen = GetterUtil.getBoolean(request.getAttribute("liferay-application-list:panel-category-content:showOpen"));
%>

<liferay-application-list:panel-category
	panelCategory="<%= panelCategory %>"
	showOpen="<%= showOpen %>"
/>