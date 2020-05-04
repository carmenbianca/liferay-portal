<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/dynamic_section/init.jsp" %>

<%
FileEntry fileEntry = (FileEntry)request.getAttribute("info_panel.jsp-fileEntry");
%>

<liferay-sharing:collaborators
	className="<%= DLFileEntryConstants.getClassName() %>"
	classPK="<%= fileEntry.getFileEntryId() %>"
/>