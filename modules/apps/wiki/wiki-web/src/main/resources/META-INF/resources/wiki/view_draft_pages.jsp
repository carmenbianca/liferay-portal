<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/wiki/init.jsp" %>

<liferay-util:include page="/wiki/top_links.jsp" servletContext="<%= application %>" />

<div class="main-content-body">
	<liferay-ui:header
		title="draft-pages"
	/>

	<liferay-util:include page="/wiki/page_iterator.jsp" servletContext="<%= application %>">
		<liferay-util:param name="navigation" value="draft-pages" />
	</liferay-util:include>

	<c:if test="<%= WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(company.getCompanyId(), scopeGroupId, WikiPage.class.getName()) %>">
		<h2><liferay-ui:message key="pending-approval" /></h2>

		<liferay-util:include page="/wiki/page_iterator.jsp" servletContext="<%= application %>">
			<liferay-util:param name="navigation" value="pending-pages" />
		</liferay-util:include>
	</c:if>
</div>