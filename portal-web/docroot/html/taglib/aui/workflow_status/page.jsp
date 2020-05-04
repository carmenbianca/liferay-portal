<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/taglib/aui/workflow_status/init.jsp" %>

<span class="taglib-workflow-status">
	<c:if test="<%= Validator.isNotNull(id) %>">
		<span class="workflow-id">
			<span class="workflow-label"><liferay-ui:message key="id" />:</span>
			<span class="workflow-value"><%= HtmlUtil.escape(id) %></span>
		</span>
	</c:if>

	<c:if test="<%= Validator.isNotNull(version) %>">
		<span class="workflow-version">
			<span class="workflow-label"><liferay-ui:message key="version" />:</span>

			<strong class="workflow-value"><%= version %></strong>
		</span>
	</c:if>

	<span class="<%= showIcon ? "icon-file-alt workflow-status" : "workflow-status" %>">
		<c:if test="<%= showLabel %>">
			<span class="workflow-label"><liferay-ui:message key="status" />:</span>
		</c:if>

		<strong class="label label-<%= WorkflowConstants.getStatusStyle(status) %> status text-uppercase workflow-status-<%= WorkflowConstants.getStatusLabel(status) %> <%= WorkflowConstants.getStatusCssClass(status) %> workflow-value">
			<liferay-ui:message key="<%= statusMessage %>" /><%= additionalText %>
		</strong>
	</span>

	<c:if test="<%= showHelpMessage && Validator.isNotNull(helpMessage) %>">
		<liferay-ui:icon-help message="<%= helpMessage %>" />
	</c:if>
</span>