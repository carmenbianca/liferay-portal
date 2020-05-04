<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<clay:vertical-card
	verticalCard="<%= new JournalArticleVerticalCard(journalContentDisplayContext.getArticle(), journalContentDisplayContext.getAssetRenderer(), renderRequest) %>"
/>