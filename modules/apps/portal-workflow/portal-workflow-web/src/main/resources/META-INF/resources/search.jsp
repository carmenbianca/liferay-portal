<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<li>
	<aui:form action="<%= selectedWorkflowPortletTab.getSearchURL(renderRequest, renderResponse) %>" method="post" name="fm1">
		<liferay-util:include page="<%= selectedWorkflowPortletTab.getSearchJspPath() %>" servletContext="<%= selectedWorkflowPortletTab.getServletContext() %>" />
	</aui:form>
</li>