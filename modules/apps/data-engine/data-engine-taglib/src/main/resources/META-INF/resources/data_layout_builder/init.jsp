<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

@generated
--%>

<%@ include file="/init.jsp" %>

<%
java.util.List<java.util.Map> additionalPanels = (java.util.List<java.util.Map>)request.getAttribute("liferay-data-engine:data-layout-builder:additionalPanels");
java.lang.String componentId = GetterUtil.getString((java.lang.String)request.getAttribute("liferay-data-engine:data-layout-builder:componentId"));
java.lang.String contentType = GetterUtil.getString((java.lang.String)request.getAttribute("liferay-data-engine:data-layout-builder:contentType"));
java.lang.Long dataDefinitionId = GetterUtil.getLong(String.valueOf(request.getAttribute("liferay-data-engine:data-layout-builder:dataDefinitionId")));
java.lang.Long dataLayoutId = GetterUtil.getLong(String.valueOf(request.getAttribute("liferay-data-engine:data-layout-builder:dataLayoutId")));
java.lang.Long groupId = GetterUtil.getLong(String.valueOf(request.getAttribute("liferay-data-engine:data-layout-builder:groupId")));
boolean localizable = GetterUtil.getBoolean(String.valueOf(request.getAttribute("liferay-data-engine:data-layout-builder:localizable")));
java.lang.String namespace = GetterUtil.getString((java.lang.String)request.getAttribute("liferay-data-engine:data-layout-builder:namespace"));
java.lang.Object scopes = (java.lang.Object)request.getAttribute("liferay-data-engine:data-layout-builder:scopes");
Map<String, Object> dynamicAttributes = (Map<String, Object>)request.getAttribute("liferay-data-engine:data-layout-builder:dynamicAttributes");
%>

<%@ include file="/data_layout_builder/init-ext.jspf" %>