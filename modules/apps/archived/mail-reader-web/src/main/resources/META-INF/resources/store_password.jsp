<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
long accountId = ParamUtil.getLong(request, "accountId");
String password = ParamUtil.getString(request, "password");

MailManager mailManager = MailManager.getInstance(request);
%>

<%= mailManager.storePassword(accountId, password) %>