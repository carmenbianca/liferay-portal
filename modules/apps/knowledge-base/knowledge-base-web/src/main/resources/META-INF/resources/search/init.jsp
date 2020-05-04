<%--
/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
KBSearchPortletInstanceConfiguration kbSearchPortletInstanceConfiguration = portletDisplay.getPortletInstanceConfiguration(KBSearchPortletInstanceConfiguration.class);

request.setAttribute("init.jsp-enableKBArticleAssetLinks", kbSearchPortletInstanceConfiguration.enableKBArticleAssetLinks());
request.setAttribute("init.jsp-enableKBArticleDescription", kbSearchPortletInstanceConfiguration.enableKBArticleDescription());
request.setAttribute("init.jsp-enableKBArticleHistory", kbSearchPortletInstanceConfiguration.enableKBArticleHistory());
request.setAttribute("init.jsp-enableKBArticlePrint", kbSearchPortletInstanceConfiguration.enableKBArticlePrint());
request.setAttribute("init.jsp-enableKBArticleRatings", kbSearchPortletInstanceConfiguration.enableKBArticleRatings());
request.setAttribute("init.jsp-enableKBArticleSubscriptions", kbSearchPortletInstanceConfiguration.enableKBArticleSubscriptions());
request.setAttribute("init.jsp-enableKBArticleViewCountIncrement", kbSearchPortletInstanceConfiguration.enableKBArticleViewCountIncrement());
request.setAttribute("init.jsp-showKBArticleAssetEntries", kbSearchPortletInstanceConfiguration.showKBArticleAssetEntries());
request.setAttribute("init.jsp-showKBArticleAttachments", kbSearchPortletInstanceConfiguration.showKBArticleAttachments());
request.setAttribute("init.jsp-socialBookmarksDisplayStyle", kbSearchPortletInstanceConfiguration.socialBookmarksDisplayStyle());
request.setAttribute("init.jsp-socialBookmarksTypes", kbSearchPortletInstanceConfiguration.socialBookmarksTypes());
%>