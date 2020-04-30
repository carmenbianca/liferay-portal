<%--
/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/admin/common/init.jsp" %>

<%
KBArticle kbArticle = (KBArticle)request.getAttribute(KBWebKeys.KNOWLEDGE_BASE_KB_ARTICLE);
%>

<c:if test="<%= enableKBArticleAssetLinks %>">
	<liferay-asset:asset-links
		className="<%= KBArticle.class.getName() %>"
		classPK="<%= kbArticle.getClassPK() %>"
	/>
</c:if>