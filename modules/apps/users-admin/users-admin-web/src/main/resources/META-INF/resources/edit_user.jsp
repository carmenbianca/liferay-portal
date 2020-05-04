<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String backURL = ParamUtil.getString(request, "backURL");

User selUser = PortalUtil.getSelectedUser(request);

PortletURL portletURL = liferayPortletResponse.createRenderURL();

if (selUser != null) {
	portletURL.setParameter("p_u_i_d", String.valueOf(selUser.getUserId()));
}

portletURL.setParameter("mvcRenderCommandName", "/users_admin/edit_user");

if (Validator.isNotNull(backURL)) {
	portletURL.setParameter("backURL", backURL);
}
%>

<liferay-frontend:screen-navigation
	containerCssClass="col-lg-8"
	containerWrapperCssClass="container-fluid container-fluid-max-xl container-form-lg"
	context="<%= selUser %>"
	headerContainerCssClass=""
	inverted="<%= layout.isTypeControlPanel() %>"
	key="<%= UserScreenNavigationEntryConstants.SCREEN_NAVIGATION_KEY_USERS %>"
	menubarCssClass="menubar menubar-transparent menubar-vertical-expand-lg"
	navCssClass="col-lg-3"
	portletURL="<%= portletURL %>"
/>