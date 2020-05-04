<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
int depth = PrefsParamUtil.getInteger(portletPreferences, request, "depth", WikiNavigationConstants.DEPTH_ALL);

long selNodeId = PrefsParamUtil.getLong(portletPreferences, request, "selNodeId");

WikiGroupServiceConfiguration wikiGroupServiceConfiguration = (WikiGroupServiceConfiguration)request.getAttribute(WikiGroupServiceConfiguration.class.getName());

if (selNodeId <= 0) {
	try {
		WikiNode node = WikiNodeServiceUtil.getNode(themeDisplay.getScopeGroupId(), wikiGroupServiceConfiguration.initialNodeName());

		selNodeId = node.getNodeId();
	}
	catch (Exception e) {
	}
}

themeDisplay.setThemeJsBarebone(false);
%>