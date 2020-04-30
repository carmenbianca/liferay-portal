<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
LayoutItemSelectorViewDisplayContext layoutItemSelectorViewDisplayContext = (LayoutItemSelectorViewDisplayContext)request.getAttribute(LayoutsItemSelectorWebKeys.LAYOUT_ITEM_SELECTOR_VIEW_DISPLAY_CONTEXT);
%>

<liferay-layout:select-layout
	checkDisplayPage="<%= layoutItemSelectorViewDisplayContext.isCheckDisplayPage() %>"
	enableCurrentPage="<%= layoutItemSelectorViewDisplayContext.isEnableCurrentPage() %>"
	followURLOnTitleClick="<%= layoutItemSelectorViewDisplayContext.isFollowURLOnTitleClick() %>"
	itemSelectorSaveEvent="<%= HtmlUtil.escapeJS(layoutItemSelectorViewDisplayContext.getItemSelectedEventName()) %>"
	multiSelection="<%= layoutItemSelectorViewDisplayContext.isMultiSelection() %>"
	namespace="<%= liferayPortletResponse.getNamespace() %>"
	pathThemeImages="<%= themeDisplay.getPathThemeImages() %>"
	privateLayout="<%= layoutItemSelectorViewDisplayContext.isPrivateLayout() %>"
	showHiddenLayouts="<%= layoutItemSelectorViewDisplayContext.isShowHiddenPages() %>"
/>