<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String className = GetterUtil.getString((String)request.getAttribute("liferay-social-bookmarks:bookmarks:className"));
long classPK = GetterUtil.getLong((Long)request.getAttribute("liferay-social-bookmarks:bookmarks:classPK"));
String displayStyle = GetterUtil.getString((String)request.getAttribute("liferay-social-bookmarks:bookmarks:displayStyle"));
int maxInlineItems = GetterUtil.getInteger(request.getAttribute("liferay-social-bookmarks:bookmarks:maxInlineItems"));
String target = GetterUtil.getString((String)request.getAttribute("liferay-social-bookmarks:bookmarks:target"));
String title = GetterUtil.getString((String)request.getAttribute("liferay-social-bookmarks:bookmarks:title"));
String[] types = SocialBookmarksRegistryUtil.getValidTypes((String[])request.getAttribute("liferay-social-bookmarks:bookmarks:types"));
String url = GetterUtil.getString((String)request.getAttribute("liferay-social-bookmarks:bookmarks:url"));
%>