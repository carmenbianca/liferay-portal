<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
JournalArticle article = journalDisplayContext.getArticle();

long assetEntryId = 0;
long classPK = 0;

if (article != null) {
	classPK = article.getResourcePrimKey();

	if (!article.isApproved() && (article.getVersion() != JournalArticleConstants.VERSION_DEFAULT)) {
		AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(JournalArticle.class.getName(), article.getPrimaryKey());

		if (assetEntry != null) {
			assetEntryId = assetEntry.getEntryId();
			classPK = article.getPrimaryKey();
		}
	}
}
%>

<liferay-ui:error-marker
	key="<%= WebKeys.ERROR_SECTION %>"
	value="related-assets"
/>

<aui:model-context bean="<%= article %>" model="<%= JournalArticle.class %>" />

<liferay-asset:input-asset-links
	assetEntryId="<%= assetEntryId %>"
	className="<%= JournalArticle.class.getName() %>"
	classPK="<%= classPK %>"
/>