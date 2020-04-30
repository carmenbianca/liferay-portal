<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
SocialBookmark socialBookmark = (SocialBookmark)request.getAttribute("liferay-social-bookmarks:bookmark:socialBookmark");
String title = GetterUtil.getString((String)request.getAttribute("liferay-social-bookmarks:bookmark:title"));
String url = GetterUtil.getString((String)request.getAttribute("liferay-social-bookmarks:bookmark:url"));
%>

<clay:link
	buttonStyle="outline-secondary"
	elementClasses="btn-monospaced btn-outline-borderless btn-sm lfr-portal-tooltip"
	href="<%= socialBookmark.getPostURL(title, url) %>"
	icon="example"
	spritemap="<%= PortalUtil.getStaticResourceURL(request, application.getContextPath() + "/icons.svg") %>"
	title="<%= socialBookmark.getName(locale) %>"
/>