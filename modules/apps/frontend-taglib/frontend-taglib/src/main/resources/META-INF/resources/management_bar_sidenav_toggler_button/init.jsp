<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String cssClass = (String)request.getAttribute("liferay-frontend:management-bar-sidenav-toggler-button:cssClass");
Map<String, Object> data = (Map<String, Object>)request.getAttribute("liferay-frontend:management-bar-sidenav-toggler-button:data");
boolean disabled = GetterUtil.getBoolean(request.getAttribute("liferay-frontend:management-bar-sidenav-toggler-button:disabled"));
String href = (String)request.getAttribute("liferay-frontend:management-bar-sidenav-toggler-button:href");
String icon = (String)request.getAttribute("liferay-frontend:management-bar-sidenav-toggler-button:icon");
String iconCssClass = (String)request.getAttribute("liferay-frontend:management-bar-sidenav-toggler-button:iconCssClass");
String id = (String)request.getAttribute("liferay-frontend:management-bar-sidenav-toggler-button:id");
String label = (String)request.getAttribute("liferay-frontend:management-bar-sidenav-toggler-button:label");
String position = (String)request.getAttribute("liferay-frontend:management-bar-sidenav-toggler-button:position");
String type = (String)request.getAttribute("liferay-frontend:management-bar-sidenav-toggler-button:type");
String typeMobile = (String)request.getAttribute("liferay-frontend:management-bar-sidenav-toggler-button:typeMobile");
String width = (String)request.getAttribute("liferay-frontend:management-bar-sidenav-toggler-button:width");

String sidenavId = liferayPortletResponse.getNamespace() + "infoPanelId";

if (Validator.isNull(href)) {
	href = "#" + sidenavId;
}

if (Validator.isNull(position)) {
	position = "right";
}

if (Validator.isNull(type)) {
	type = "relative";
}

if (Validator.isNull(typeMobile)) {
	typeMobile = "fixed";
}

if (Validator.isNull(width)) {
	width = "320px";
}
%>