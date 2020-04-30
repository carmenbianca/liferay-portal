<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "selectFolder");

Map<String, Object> data = HashMapBuilder.<String, Object>put(
	"itemSelectorSaveEvent", eventName
).put(
	"namespace", liferayPortletResponse.getNamespace()
).put(
	"nodes", journalDisplayContext.getFoldersJSONArray()
).put(
	"pathThemeImages", themeDisplay.getPathThemeImages()
).build();
%>

<react:component
	data="<%= data %>"
	module="js/SelectFolder.es"
/>