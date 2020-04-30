<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/data_layout_builder/init.jsp" %>

<liferay-editor:resources
	editorName="alloyeditor"
/>

<liferay-util:html-top>
	<link href="<%= PortalUtil.getStaticResourceURL(request, PortalUtil.getPathModule() + "/dynamic-data-mapping-form-builder/css/main.css") %>" rel="stylesheet" />
	<link href="<%= PortalUtil.getStaticResourceURL(request, PortalUtil.getPathModule() + "/dynamic-data-mapping-form-renderer/css/main.css") %>" rel="stylesheet" />
	<link href="<%= PortalUtil.getStaticResourceURL(request, PortalUtil.getPathModule() + "/data-engine-taglib/data_layout_builder/css/main.css") %>" rel="stylesheet" />
</liferay-util:html-top>

<liferay-util:dynamic-include key="com.liferay.data.engine.taglib#/data_layout_builder/start.jsp#pre" />

<liferay-util:dynamic-include key="com.liferay.data.engine.taglib#/data_layout_builder/start.jsp#post" />