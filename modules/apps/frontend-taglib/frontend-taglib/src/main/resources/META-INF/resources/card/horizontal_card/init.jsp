<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/card/init.jsp" %>

<%
String colHTML = (String)request.getAttribute("liferay-frontend:card:colHTML");
Map<String, Object> linkData = (Map<String, Object>)request.getAttribute("liferay-frontend:card:linkData");
String text = (String)request.getAttribute("liferay-frontend:card:text");
%>