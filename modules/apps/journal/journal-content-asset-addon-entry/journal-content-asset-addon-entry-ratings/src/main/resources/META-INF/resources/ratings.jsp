<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
JournalArticleDisplay articleDisplay = (JournalArticleDisplay)request.getAttribute(WebKeys.JOURNAL_ARTICLE_DISPLAY);

String viewMode = ParamUtil.getString(request, "viewMode");
%>

<c:if test="<%= !viewMode.equals(Constants.PRINT) %>">
	<div class="content-metadata-asset-addon-entry content-metadata-ratings">
		<liferay-ratings:ratings
			className="<%= JournalArticle.class.getName() %>"
			classPK="<%= articleDisplay.getResourcePrimKey() %>"
		/>
	</div>
</c:if>