<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/journal_article/init.jsp" %>

<liferay-util:dynamic-include key="com.liferay.journal.taglib#/journal_article/page.jsp#pre" />

<%
JournalArticleDisplay articleDisplay = (JournalArticleDisplay)request.getAttribute("liferay-journal:journal-article:articleDisplay");
boolean showTitle = GetterUtil.getBoolean((String)request.getAttribute("liferay-journal:journal-article:showTitle"));
String wrapperCssClass = (String)request.getAttribute("liferay-journal:journal-article:wrapperCssClass");
%>

<div class="journal-content-article <%= Validator.isNotNull(wrapperCssClass) ? wrapperCssClass : StringPool.BLANK %>" data-analytics-asset-id="<%= articleDisplay.getArticleId() %>" data-analytics-asset-title="<%= HtmlUtil.escapeAttribute(articleDisplay.getTitle()) %>" data-analytics-asset-type="web-content">
	<c:if test="<%= showTitle %>">
		<%= HtmlUtil.escape(articleDisplay.getTitle()) %>
	</c:if>

	<%= articleDisplay.getContent() %>
</div>

<%
List<AssetTag> assetTags = AssetTagLocalServiceUtil.getTags(JournalArticleDisplay.class.getName(), articleDisplay.getResourcePrimKey());

PortalUtil.setPageKeywords(ListUtil.toString(assetTags, AssetTag.NAME_ACCESSOR), request);
%>

<liferay-util:dynamic-include key="com.liferay.journal.taglib#/journal_article/page.jsp#post" />