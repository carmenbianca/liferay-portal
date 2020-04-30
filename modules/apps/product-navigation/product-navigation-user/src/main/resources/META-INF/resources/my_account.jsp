<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
PanelCategory panelCategory = (PanelCategory)request.getAttribute(ApplicationListWebKeys.PANEL_CATEGORY);

MyAccountPanelCategoryDisplayContext myAccountPanelCategoryDisplayContext = new MyAccountPanelCategoryDisplayContext(liferayPortletRequest, liferayPortletResponse);
%>

<liferay-application-list:panel-category
	panelCategory="<%= panelCategory %>"
	showOpen="<%= true %>"
/>

<c:if test="<%= myAccountPanelCategoryDisplayContext.isShowMySiteGroup(false) %>">
	<aui:a cssClass='<%= "list-group-heading" + (myAccountPanelCategoryDisplayContext.isMySiteGroupActive(false) ? " active" : StringPool.BLANK) %>' href="<%= myAccountPanelCategoryDisplayContext.getMySiteGroupURL(false) %>" label="my-profile" />
</c:if>

<c:if test="<%= myAccountPanelCategoryDisplayContext.isShowMySiteGroup(true) %>">
	<aui:a cssClass='<%= "list-group-heading" + (myAccountPanelCategoryDisplayContext.isMySiteGroupActive(true) ? " active" : StringPool.BLANK) %>' href="<%= myAccountPanelCategoryDisplayContext.getMySiteGroupURL(true) %>" label="my-dashboard" />
</c:if>