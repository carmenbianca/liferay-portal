<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
JournalArticle article = journalDisplayContext.getArticle();

JournalEditArticleDisplayContext journalEditArticleDisplayContext = new JournalEditArticleDisplayContext(request, liferayPortletResponse, article);
%>

<p class="mb-2 text-secondary">
	<%= journalEditArticleDisplayContext.getFriendlyURLBase() %>
</p>

<liferay-ui:input-localized
	availableLocales="<%= journalEditArticleDisplayContext.getAvailableLocales() %>"
	defaultLanguageId="<%= journalEditArticleDisplayContext.getDefaultArticleLanguageId() %>"
	maxLength='<%= String.valueOf(ModelHintsUtil.getMaxLength(JournalArticle.class.getName(), "urlTitle")) %>'
	name="friendlyURL"
	selectedLanguageId="<%= journalEditArticleDisplayContext.getSelectedLanguageId() %>"
	xml="<%= (article != null) ? HttpUtil.decodeURL(article.getFriendlyURLsXML()) : StringPool.BLANK %>"
/>