<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

PowwowMeeting powwowMeeting = (PowwowMeeting)row.getObject();
%>

<liferay-ui:icon-menu>
	<%@ include file="/meetings/meeting_action.jspf" %>
</liferay-ui:icon-menu>