<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/data_layout_builder/init.jsp" %>

<portlet:renderURL var="basePortletURL" />

<%
Map<String, Object> data = HashMapBuilder.<String, Object>put(
	"availableLanguageIds", availableLanguageIds
).put(
	"config", configJSONObject
).put(
	"contentType", contentType
).put(
	"context", dataLayoutJSONObject
).put(
	"dataDefinitionId", dataDefinitionId
).put(
	"dataLayoutBuilderElementId", renderResponse.getNamespace() + "-data-layout-builder"
).put(
	"dataLayoutBuilderId", componentId
).put(
	"dataLayoutId", dataLayoutId
).put(
	"fieldTypes", fieldTypesJSONArray
).put(
	"fieldTypesModules", fieldTypesModules
).put(
	"groupId", groupId
).put(
	"localizable", localizable
).put(
	"sidebarPanels", sidebarPanels
).put(
	"spritemap", themeDisplay.getPathThemeImages() + "/lexicon/icons.svg"
).build();
%>

<div id="<%= componentId + "container" %>">
	<react:component
		data="<%= data %>"
		module="data_layout_builder/js/App.es"
	/>
</div>