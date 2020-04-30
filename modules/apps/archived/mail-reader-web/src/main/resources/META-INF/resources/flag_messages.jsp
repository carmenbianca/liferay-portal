<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
long[] messageIds = ParamUtil.getLongValues(request, "messageIds");
int flag = ParamUtil.getInteger(request, "flag");
boolean value = ParamUtil.getBoolean(request, "value");

MailManager mailManager = MailManager.getInstance(request);
%>

<c:if test="<%= mailManager != null %>">
	<%= mailManager.flagMessages(messageIds, flag, value) %>
</c:if>