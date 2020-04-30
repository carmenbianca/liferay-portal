<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String buttons = (String)request.getAttribute("liferay-frontend:info-bar:buttons");
boolean fixed = GetterUtil.getBoolean(request.getAttribute("liferay-frontend:info-bar:fixed"));
%>