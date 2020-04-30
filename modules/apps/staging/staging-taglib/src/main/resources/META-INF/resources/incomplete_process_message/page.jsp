<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/incomplete_process_message/init.jsp" %>

<div class="<%= (incompleteBackgroundTaskCount == 0) ? "hide" : "" %> incomplete-process-message">
	<div class="alert alert-info">
		<c:choose>
			<c:when test="<%= incompleteBackgroundTaskCount == 1 %>">
				<liferay-ui:message key="there-is-currently-1-process-in-progress" />
			</c:when>
			<c:when test="<%= incompleteBackgroundTaskCount > 1 %>">
				<liferay-ui:message arguments="<%= incompleteBackgroundTaskCount - 1 %>" key="there-is-currently-1-process-in-progress-and-x-pending" translateArguments="<%= false %>" />
			</c:when>
			<c:otherwise>
				<liferay-ui:message key="there-are-no-processes-in-progress-anymore" />
			</c:otherwise>
		</c:choose>
	</div>
</div>