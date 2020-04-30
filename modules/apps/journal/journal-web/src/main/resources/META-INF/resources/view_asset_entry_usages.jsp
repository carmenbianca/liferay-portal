<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

long groupId = ParamUtil.getLong(request, "groupId");
String articleId = ParamUtil.getString(request, "articleId");

JournalArticle article = JournalArticleLocalServiceUtil.fetchArticle(groupId, articleId);

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(redirect);

renderResponse.setTitle(article.getTitle(themeDisplay.getLocale()));
%>

<liferay-layout:layout-classed-model-usages-admin
	className="<%= JournalArticle.class.getName() %>"
	classPK="<%= JournalArticleAssetRenderer.getClassPK(article) %>"
/>