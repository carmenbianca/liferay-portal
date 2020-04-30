<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
TasksEntry entry = (TasksEntry)request.getAttribute(WebKeys.TASKS_ENTRY);
%>

<%= entry.getTitle() %>