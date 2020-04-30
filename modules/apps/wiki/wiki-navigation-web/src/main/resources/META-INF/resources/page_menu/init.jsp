<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
long selNodeId = PrefsParamUtil.getLong(portletPreferences, request, "selNodeId");
String selTitle = PrefsParamUtil.getString(portletPreferences, request, "selTitle");

WikiPage wikiPage = null;

if ((selNodeId > 0) && Validator.isNotNull(selTitle)) {
	try {
		wikiPage = WikiPageServiceUtil.getPage(selNodeId, selTitle);
	}
	catch (Exception e) {
	}
}
%>