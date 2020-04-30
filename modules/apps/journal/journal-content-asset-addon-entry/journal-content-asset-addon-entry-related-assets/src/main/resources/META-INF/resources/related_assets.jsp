<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
JournalArticleDisplay articleDisplay = (JournalArticleDisplay)request.getAttribute(WebKeys.JOURNAL_ARTICLE_DISPLAY);
%>

<div class="content-metadata-asset-addon-entry content-metadata-asset-addon-entry-links">
	<liferay-asset:asset-links
		className="<%= JournalArticle.class.getName() %>"
		classPK="<%= articleDisplay.getResourcePrimKey() %>"
	/>
</div>