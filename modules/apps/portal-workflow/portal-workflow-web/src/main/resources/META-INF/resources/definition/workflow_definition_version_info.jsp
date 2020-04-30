<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/definition/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

WorkflowDefinition workflowDefinition = (WorkflowDefinition)row.getObject();

String userName = workflowDefinitionDisplayContext.getUserNameOrBlank(workflowDefinition);
%>

<div class="autofit-col autofit-col-expand">
	<div class="list-group-title"><%= dateFormatTime.format(workflowDefinition.getModifiedDate()) %></div>
	<div class="list-group-subtitle"><%= HtmlUtil.escape(userName) %></div>
</div>