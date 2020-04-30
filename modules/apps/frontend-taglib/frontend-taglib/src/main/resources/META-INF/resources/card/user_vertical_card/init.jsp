<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/card/init.jsp" %>

<%
String footer = (String)request.getAttribute("liferay-frontend:card:footer");
String header = (String)request.getAttribute("liferay-frontend:card:header");
String onClick = (String)request.getAttribute("liferay-frontend:card:onClick");
String subtitle = (String)request.getAttribute("liferay-frontend:card:subtitle");
String title = (String)request.getAttribute("liferay-frontend:card:title");
User user2 = (User)request.getAttribute("liferay-frontend:card:user");
%>