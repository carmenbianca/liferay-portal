<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/admin/common/init.jsp" %>

<%
KBArticle kbArticle = (KBArticle)request.getAttribute(KBWebKeys.KNOWLEDGE_BASE_KB_ARTICLE);

KBArticleURLHelper kbArticleURLHelper = new KBArticleURLHelper(renderRequest, renderResponse, templatePath);

PortletURL viewKBArticleURL = kbArticleURLHelper.createViewURL(kbArticle);
%>

<liferay-social-bookmarks:bookmarks
	className="<%= KBArticle.class.getName() %>"
	classPK="<%= kbArticle.getKbArticleId() %>"
	displayStyle="<%= socialBookmarksDisplayStyle %>"
	target="_blank"
	title="<%= kbArticle.getTitle() %>"
	types="<%= SocialBookmarksUtil.getSocialBookmarksTypes(socialBookmarksTypes) %>"
	urlImpl="<%= viewKBArticleURL %>"
/>