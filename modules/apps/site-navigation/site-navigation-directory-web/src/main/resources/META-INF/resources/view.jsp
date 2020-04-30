<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<liferay-ui:sites-directory
	displayStyle="<%= sitesDirectoryDisplayContext.getDisplayStyle() %>"
	sites="<%= sitesDirectoryDisplayContext.getSites() %>"
/>