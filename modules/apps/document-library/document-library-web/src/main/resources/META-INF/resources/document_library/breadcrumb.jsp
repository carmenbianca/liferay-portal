<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/document_library/init.jsp" %>

<%
Folder folder = (Folder)request.getAttribute("view.jsp-folder");

DLBreadcrumbUtil.addPortletBreadcrumbEntries(folder, request, liferayPortletResponse);
%>

<liferay-ui:breadcrumb
	showCurrentGroup="<%= false %>"
	showGuestGroup="<%= false %>"
	showLayout="<%= false %>"
	showParentGroups="<%= false %>"
/>