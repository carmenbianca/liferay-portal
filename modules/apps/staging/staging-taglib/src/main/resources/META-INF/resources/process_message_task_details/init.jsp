<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
long backgroundTaskId = GetterUtil.getLong(request.getAttribute("liferay-staging:process-message-task-details:backgroundTaskId"));
String backgroundTaskStatusMessage = GetterUtil.getString(request.getAttribute("liferay-staging:process-message-task-details:backgroundTaskStatusMessage"));
String linkClass = GetterUtil.getString(request.getAttribute("liferay-staging:process-message-task-details:linkClass"));
%>