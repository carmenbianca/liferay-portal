<%--
/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/taglib/init.jsp" %>

<%
String id = (String)request.getAttribute("liferay-ui:toggle-area:id");
String showImage = (String)request.getAttribute("liferay-ui:toggle-area:showImage");
String hideImage = (String)request.getAttribute("liferay-ui:toggle-area:hideImage");
String showMessage = (String)request.getAttribute("liferay-ui:toggle-area:showMessage");
String hideMessage = (String)request.getAttribute("liferay-ui:toggle-area:hideMessage");
boolean defaultShowContent = GetterUtil.getBoolean((String)request.getAttribute("liferay-ui:toggle-area:defaultShowContent"));
String stateVar = (String)request.getAttribute("liferay-ui:toggle-area:stateVar");
String align = (String)request.getAttribute("liferay-ui:toggle-area:align");
%>