<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%@ page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem" %>

<%
List<DropdownItem> actionDropdownItems = (List<DropdownItem>)request.getAttribute("liferay-frontend:empty-result-message:actionDropdownItems");
String animationTypeCssClass = GetterUtil.getString((String)request.getAttribute("liferay-frontend:empty-result-message:animationTypeCssClass"));
String componentId = GetterUtil.getString((String)request.getAttribute("liferay-frontend:empty-result-message:componentId"));
String defaultEventHandler = GetterUtil.getString((String)request.getAttribute("liferay-frontend:empty-result-message:defaultEventHandler"));
String description = (String)request.getAttribute("liferay-frontend:empty-result-message:description");
String elementType = (String)request.getAttribute("liferay-frontend:empty-result-message:elementType");
String title = (String)request.getAttribute("liferay-frontend:empty-result-message:title");
%>