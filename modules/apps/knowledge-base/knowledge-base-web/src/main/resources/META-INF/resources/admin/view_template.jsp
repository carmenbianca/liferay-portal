<%--
/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/admin/init.jsp" %>

<liferay-util:include page="/admin/common/top_tabs.jsp" servletContext="<%= application %>" />

<%
KBTemplate kbTemplate = (KBTemplate)request.getAttribute(KBWebKeys.KNOWLEDGE_BASE_KB_TEMPLATE);
%>

<div class="float-container kb-entity-header">
	<div class="kb-title">
		<%= HtmlUtil.escape(kbTemplate.getTitle()) %>
	</div>
</div>

<div class="kb-entity-body">
	<%= kbTemplate.getContent() %>

	<liferay-util:include page="/admin/template_comments.jsp" servletContext="<%= application %>" />
</div>