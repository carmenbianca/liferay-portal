<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
long reportedUserId = themeDisplay.getDefaultUserId();

Group group = layout.getGroup();

if (group.isUser()) {
	reportedUserId = group.getClassPK();
}
%>

<liferay-flags:flags
	className="<%= Layout.class.getName() %>"
	classPK="<%= layout.getPlid() %>"
	contentTitle="<%= layout.getHTMLTitle(LocaleUtil.getDefault()) %>"
	message="flag-this-page"
	reportedUserId="<%= reportedUserId %>"
/>