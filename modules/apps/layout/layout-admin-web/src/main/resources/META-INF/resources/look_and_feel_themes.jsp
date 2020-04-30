<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
boolean editable = ParamUtil.getBoolean(request, "editable", true);
%>

<c:choose>
	<c:when test="<%= editable %>">
		<liferay-util:include page="/look_and_feel_themes_edit.jsp" servletContext="<%= application %>" />
	</c:when>
	<c:otherwise>
		<liferay-util:include page="/look_and_feel_themes_info.jsp" servletContext="<%= application %>" />
	</c:otherwise>
</c:choose>