<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/ct_display/init.jsp" %>

<%
JournalArticleDisplay journalArticleDisplay = (JournalArticleDisplay)request.getAttribute(WebKeys.JOURNAL_ARTICLE_DISPLAY);

long siteGroupId = PortalUtil.getSiteGroupId(journalArticleDisplay.getGroupId());

DDMStructure ddmStructure = DDMStructureLocalServiceUtil.fetchStructure(siteGroupId, ClassNameLocalServiceUtil.getClassNameId(JournalArticle.class), journalArticleDisplay.getDDMStructureKey(), true);

DDMTemplate ddmTemplate = DDMTemplateLocalServiceUtil.fetchTemplate(siteGroupId, PortalUtil.getClassNameId(DDMStructure.class), journalArticleDisplay.getDDMTemplateKey(), true);
%>

<p>
	<b><liferay-ui:message key="id" /></b>: <%= journalArticleDisplay.getArticleId() %>
</p>

<p>
	<b><liferay-ui:message key="version" /></b>: <%= journalArticleDisplay.getVersion() %>
</p>

<p>
	<b><liferay-ui:message key="title" /></b>: <%= HtmlUtil.escape(journalArticleDisplay.getTitle()) %>
</p>

<p>
	<b><liferay-ui:message key="description" /></b>: <%= HtmlUtil.escape(journalArticleDisplay.getDescription()) %>
</p>

<p>
	<b><liferay-ui:message key="structure" /></b>: <%= HtmlUtil.escape(ddmStructure.getName(locale)) %>
</p>

<p>
	<b><liferay-ui:message key="template" /></b>: <%= (ddmTemplate == null) ? "" : HtmlUtil.escape(ddmTemplate.getName(locale)) %>
</p>

<b><liferay-ui:message key="content" /></b>:

<liferay-journal:journal-article-display
	articleDisplay="<%= journalArticleDisplay %>"
/>