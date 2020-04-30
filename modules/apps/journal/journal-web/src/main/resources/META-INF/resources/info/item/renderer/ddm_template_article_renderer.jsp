<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/info/item/renderer/init.jsp" %>

<%
JournalArticle article = (JournalArticle)request.getAttribute(WebKeys.JOURNAL_ARTICLE);
String ddmTemplateKey = (String)request.getAttribute(WebKeys.JOURNAL_TEMPLATE_ID);
%>

<liferay-journal:journal-article
	articleId="<%= article.getArticleId() %>"
	ddmTemplateKey="<%= ddmTemplateKey %>"
	groupId="<%= article.getGroupId() %>"
	languageId="<%= themeDisplay.getLanguageId() %>"
/>