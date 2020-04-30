<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/document_library/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

FileVersion fileVersion = null;

if (row != null) {
	fileVersion = (FileVersion)row.getObject();
}
else {
	fileVersion = (FileVersion)request.getAttribute("info_panel.jsp-fileVersion");
}

DLViewFileEntryHistoryDisplayContext dlViewFileEntryHistoryDisplayContext = dlDisplayContextProvider.getDLViewFileEntryHistoryDisplayContext(request, response, fileVersion);
%>

<liferay-ui:menu
	menu="<%= dlViewFileEntryHistoryDisplayContext.getMenu() %>"
/>