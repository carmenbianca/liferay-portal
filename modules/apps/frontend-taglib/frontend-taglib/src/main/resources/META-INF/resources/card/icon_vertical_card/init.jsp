<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/card/init.jsp" %>

<%
String footer = (String)request.getAttribute("liferay-frontend:card:footer");
String header = (String)request.getAttribute("liferay-frontend:card:header");
String icon = GetterUtil.getString(request.getAttribute("liferay-frontend:card:icon"));
String onClick = (String)request.getAttribute("liferay-frontend:card:onClick");
String stickerBottom = GetterUtil.getString(request.getAttribute("liferay-frontend:card:stickerBottom"));
String subtitle = (String)request.getAttribute("liferay-frontend:card:subtitle");
String title = (String)request.getAttribute("liferay-frontend:card:title");
%>