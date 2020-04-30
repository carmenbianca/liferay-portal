<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/process_duration/init.jsp" %>

<c:if test="<%= duration > 0 %>">
	<c:if test="<%= !listView %>">
		<liferay-ui:message key="duration" />:
	</c:if>

	<%= timeDescription %>
</c:if>