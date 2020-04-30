<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/announcements/init.jsp" %>

<%
boolean portletTitleBasedNavigation = GetterUtil.getBoolean(portletConfig.getInitParameter("portlet-title-based-navigation"));

if (portletTitleBasedNavigation) {
	portletDisplay.setShowBackIcon(true);

	String backURL = request.getHeader(HttpHeaders.REFERER);

	if (Validator.isNull(backURL)) {
		PortletURL backURLObj = liferayPortletResponse.createRenderURL();

		backURLObj.setParameter("mvcRenderCommandName", "/announcements/view");

		backURL = backURLObj.toString();
	}

	portletDisplay.setURLBack(backURL);

	renderResponse.setTitle(LanguageUtil.get(resourceBundle, "error"));
}
%>

<c:if test="<%= !portletTitleBasedNavigation %>">
	<liferay-ui:error-header />
</c:if>

<liferay-ui:error exception="<%= NoSuchEntryException.class %>" message="the-entry-could-not-be-found" />

<liferay-ui:error-principal />