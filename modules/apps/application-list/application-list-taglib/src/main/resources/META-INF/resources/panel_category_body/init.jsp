<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String id = (String)request.getAttribute("liferay-application-list:panel-category-body:id");
List<PanelApp> panelApps = (List<PanelApp>)request.getAttribute("liferay-application-list:panel-category-body:panelApps");
PanelCategory panelCategory = (PanelCategory)request.getAttribute("liferay-application-list:panel-category-body:panelCategory");
%>