<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/bookmark/init.jsp" %>

<%
String icon = PropsUtil.get(PropsKeys.SOCIAL_BOOKMARK_ICON, new Filter(type));
%>

<liferay-ui:icon
	image="<%= icon %>"
	label="<%= false %>"
	linkCssClass="btn btn-borderless btn-monospaced btn-outline-borderless btn-outline-secondary btn-sm"
	message="<%= socialBookmark.getName(locale) %>"
	method="get"
	src="<%= icon %>"
	url="<%= socialBookmark.getPostURL(title, url) %>"
/>