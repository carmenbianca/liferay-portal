<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
long folderId = ParamUtil.getLong(request, "folderId");
long[] messageIds = ParamUtil.getLongValues(request, "messageIds");

MailManager mailManager = MailManager.getInstance(request);
%>

<c:if test="<%= mailManager != null %>">
	<%= mailManager.moveMessages(folderId, messageIds) %>
</c:if>