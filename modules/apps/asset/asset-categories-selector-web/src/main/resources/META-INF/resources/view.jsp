<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
Map<String, Object> context = HashMapBuilder.<String, Object>put(
	"itemSelectorSaveEvent", HtmlUtil.escapeJS(assetCategoriesSelectorDisplayContext.getEventName())
).put(
	"multiSelection", !assetCategoriesSelectorDisplayContext.isSingleSelect()
).put(
	"namespace", liferayPortletResponse.getNamespace()
).put(
	"nodes", assetCategoriesSelectorDisplayContext.getCategoriesJSONArray()
).build();
%>

<react:component
	data="<%= context %>"
	module="js/SelectCategory.es"
/>