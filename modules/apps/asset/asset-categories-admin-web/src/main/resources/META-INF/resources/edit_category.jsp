<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
long categoryId = ParamUtil.getLong(request, "categoryId");

AssetCategory category = AssetCategoryLocalServiceUtil.fetchCategory(categoryId);
%>

<liferay-frontend:screen-navigation
	context="<%= category %>"
	key="<%= AssetCategoriesConstants.CATEGORY_KEY_GENERAL %>"
	portletURL="<%= currentURLObj %>"
/>