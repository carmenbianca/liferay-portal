<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
WorkflowNavigationDisplayContext workflowNavigationDisplayContext = (WorkflowNavigationDisplayContext)request.getAttribute(WorkflowWebKeys.WORKFLOW_NAVIGATION_DISPLAY_CONTEXT);
%>

<c:if test="<%= workflowPortletTabs.size() != 1 %>">
	<clay:navigation-bar
		inverted="<%= true %>"
		navigationItems="<%= workflowNavigationDisplayContext.getNavigationItems(selectedWorkflowPortletTab, workflowPortletTabs) %>"
	/>
</c:if>