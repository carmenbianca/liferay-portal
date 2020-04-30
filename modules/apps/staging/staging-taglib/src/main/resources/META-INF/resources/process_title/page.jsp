<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/process_title/init.jsp" %>

<c:choose>
	<c:when test="<%= listView %>">
		<strong class="process-title table-list-title" id="<%= domId %>">
			<liferay-ui:message key="<%= HtmlUtil.escape(backgroundTaskName) %>" />
		</strong>
	</c:when>
	<c:otherwise>
		<strong class="process-title table-list-title" id="<%= domId %>">
			<liferay-ui:message key="<%= HtmlUtil.escape(backgroundTaskName) %>" />
		</strong>
	</c:otherwise>
</c:choose>