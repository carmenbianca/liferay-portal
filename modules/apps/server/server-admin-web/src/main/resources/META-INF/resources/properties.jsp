<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);

PortletURL serverURL = renderResponse.createRenderURL();

serverURL.setParameter("mvcRenderCommandName", "/server_admin/view");
serverURL.setParameter("tabs1", tabs1);
serverURL.setParameter("delta", String.valueOf(delta));
%>

<liferay-frontend:screen-navigation
	containerWrapperCssClass=""
	headerContainerCssClass=""
	inverted="<%= false %>"
	key="<%= ServerAdminNavigationEntryConstants.SCREEN_NAVIGATION_KEY_PROPERTIES %>"
	portletURL="<%= serverURL %>"
/>