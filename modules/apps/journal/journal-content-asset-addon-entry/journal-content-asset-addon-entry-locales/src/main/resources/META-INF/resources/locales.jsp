<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
JournalArticle article = (JournalArticle)request.getAttribute(WebKeys.JOURNAL_ARTICLE);
JournalArticleDisplay articleDisplay = (JournalArticleDisplay)request.getAttribute(WebKeys.JOURNAL_ARTICLE_DISPLAY);

String viewMode = ParamUtil.getString(request, "viewMode");
%>

<c:if test="<%= !viewMode.equals(Constants.PRINT) %>">

	<%
	String languageId = LanguageUtil.getLanguageId(request);

	String[] availableLocales = articleDisplay.getAvailableLocales();

	if (ArrayUtil.isNotEmpty(availableLocales) && !ArrayUtil.contains(availableLocales, languageId)) {
		if (article != null) {
			languageId = article.getDefaultLanguageId();
		}
		else {
			languageId = LocaleUtil.toLanguageId(LocaleUtil.getSiteDefault());

			if (!ArrayUtil.contains(availableLocales, languageId)) {
				languageId = availableLocales[0];
			}
		}
	}
	%>

	<c:if test="<%= availableLocales.length > 1 %>">
		<div class="locale-actions user-tool-asset-addon-entry">
			<liferay-ui:language
				formAction="<%= currentURL %>"
				languageId="<%= languageId %>"
				languageIds="<%= availableLocales %>"
			/>
		</div>
	</c:if>
</c:if>