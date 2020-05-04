<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%@ page import="com.liferay.staging.taglib.servlet.taglib.AlertType" %>

<%
Object bodyContent = request.getAttribute("liferay-staging:alert:bodyContent");

String bodyContentString = (bodyContent != null) ? bodyContent.toString() : StringPool.BLANK;

boolean dismissible = GetterUtil.getBoolean(request.getAttribute("liferay-staging:alert:dismissible"));
boolean fluid = GetterUtil.getBoolean(request.getAttribute("liferay-staging:alert:fluid"));
String themeDisplayPath = themeDisplay.getPathThemeImages();
String type = GetterUtil.getString(request.getAttribute("liferay-staging:alert:type"));
%>