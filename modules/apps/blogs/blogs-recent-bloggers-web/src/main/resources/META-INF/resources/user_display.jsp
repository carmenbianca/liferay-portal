<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Object[] objArray = (Object[])row.getObject();

BlogsStatsUser statsUser = (BlogsStatsUser)objArray[0];
%>

<liferay-ui:user-display
	url="<%= (String)objArray[1] %>"
	userId="<%= statsUser.getUserId() %>"
>
	<div class="blogger-post-count">
		<c:choose>
			<c:when test="<%= statsUser.getEntryCount() == 1 %>">
				<span><liferay-ui:message key="post" />:</span> <%= statsUser.getEntryCount() %>
			</c:when>
			<c:otherwise>
				<span><liferay-ui:message key="posts" />:</span> <%= statsUser.getEntryCount() %>
			</c:otherwise>
		</c:choose>
	</div>

	<div class="blogger-stars">
		<span><liferay-ui:message key="number-of-ratings" />:</span> <%= statsUser.getRatingsTotalEntries() %>
	</div>

	<div class="blogger-date">
		<span><liferay-ui:message key="date" />:</span> <%= dateFormatDate.format(statsUser.getLastPostDate()) %>
	</div>
</liferay-ui:user-display>