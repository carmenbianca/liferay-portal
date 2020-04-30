<%--
/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/taglib/init.jsp" %>

<%
Map<String, Object> data = (Map<String, Object>)request.getAttribute("liferay-ui:section:data");
String name = (String)request.getAttribute("liferay-ui:section:name");
String param = (String)request.getAttribute("liferay-ui:section:param");
boolean selected = (Boolean)request.getAttribute("liferay-ui:section:selected");
%>

<div class="<%= selected ? StringPool.BLANK : "hide" %>" <%= AUIUtil.buildData(data) %> id="<%= namespace %><%= param %><%= StringUtil.toCharCode(name) %>TabsSection">