<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String cssClass = GetterUtil.getString(request.getAttribute("liferay-frontend:vertical-card-small-image:cssClass"));
String src = GetterUtil.getString(request.getAttribute("liferay-frontend:vertical-card-small-image:src"));
%>