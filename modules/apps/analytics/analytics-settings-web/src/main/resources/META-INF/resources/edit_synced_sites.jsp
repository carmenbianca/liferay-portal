<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
boolean propertiesEnabled = true;
%>

<c:choose>
	<c:when test="<%= propertiesEnabled %>">
		<liferay-util:include page="/edit_properties.jsp" servletContext="<%= application %>" />
	</c:when>
	<c:otherwise>
		<liferay-util:include page="/edit_sites.jsp" servletContext="<%= application %>" />
	</c:otherwise>
</c:choose>