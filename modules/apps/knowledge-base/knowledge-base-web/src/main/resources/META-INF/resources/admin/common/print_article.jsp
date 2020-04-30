<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/admin/common/init.jsp" %>

<%
KBArticle kbArticle = (KBArticle)request.getAttribute(KBWebKeys.KNOWLEDGE_BASE_KB_ARTICLE);
%>

<div class="float-container kb-entity-header">
	<div class="kb-title">
		<%= HtmlUtil.escape(kbArticle.getTitle()) %>
	</div>

	<div class="kb-tools">
		<liferay-ui:icon
			icon="print"
			label="<%= true %>"
			markupView="lexicon"
			message="print"
			url="javascript:print();"
		/>
	</div>
</div>

<div class="kb-entity-body">
	<%= kbArticle.getContent() %>
</div>