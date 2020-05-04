<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String tabs1 = siteMembershipsDisplayContext.getTabs1();
%>

<c:choose>
	<c:when test='<%= tabs1.equals("users") %>'>
		<liferay-util:include page="/users.jsp" servletContext="<%= application %>" />
	</c:when>
	<c:when test='<%= tabs1.equals("organizations") %>'>
		<liferay-util:include page="/organizations.jsp" servletContext="<%= application %>" />
	</c:when>
	<c:when test='<%= tabs1.equals("user-groups") %>'>
		<liferay-util:include page="/user_groups.jsp" servletContext="<%= application %>" />
	</c:when>
</c:choose>