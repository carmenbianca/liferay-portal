<%--
/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/taglib/init.jsp" %>

<%
boolean accordion = GetterUtil.getBoolean((String)request.getAttribute("liferay-ui:panel-container:accordion"));
String cssClass = GetterUtil.getString((String)request.getAttribute("liferay-ui:panel-container:cssClass"));
String id = (String)request.getAttribute("liferay-ui:panel-container:id");
%>