<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/admin/common/init.jsp" %>

<%
KBArticle kbArticle = (KBArticle)request.getAttribute(KBWebKeys.KNOWLEDGE_BASE_KB_ARTICLE);
%>

<liferay-util:buffer
	var="html"
>
	<liferay-asset:asset-categories-summary
		className="<%= KBArticle.class.getName() %>"
		classPK="<%= kbArticle.getClassPK() %>"
		portletURL="<%= renderResponse.createRenderURL() %>"
	/>

	<liferay-asset:asset-tags-available
		className="<%= KBArticle.class.getName() %>"
		classPK="<%= kbArticle.getClassPK() %>"
	>
		<h5><liferay-ui:message key="tags" /></h5>

		<liferay-asset:asset-tags-summary
			className="<%= KBArticle.class.getName() %>"
			classPK="<%= kbArticle.getClassPK() %>"
			portletURL="<%= renderResponse.createRenderURL() %>"
		/>
	</liferay-asset:asset-tags-available>
</liferay-util:buffer>

<c:if test="<%= Validator.isNotNull(html.trim()) %>">
	<div class="kb-article-assets">
		<%= html %>
	</div>
</c:if>