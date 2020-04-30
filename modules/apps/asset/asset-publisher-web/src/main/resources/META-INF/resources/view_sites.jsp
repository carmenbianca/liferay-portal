<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
ItemSelectorViewDisplayContext itemSelectorViewDisplayContext = (ItemSelectorViewDisplayContext)request.getAttribute(AssetPublisherWebKeys.ITEM_SELECTOR_DISPLAY_CONTEXT);

GroupSearch groupSearch = itemSelectorViewDisplayContext.getGroupSearch();
%>

<liferay-site:site-browser
	displayStyle="<%= itemSelectorViewDisplayContext.getDisplayStyle() %>"
	eventName="<%= itemSelectorViewDisplayContext.getItemSelectedEventName() %>"
	groups="<%= groupSearch.getResults() %>"
	groupsCount="<%= groupSearch.getTotal() %>"
	portletURL="<%= itemSelectorViewDisplayContext.getPortletURL() %>"
	selectedGroupIds="<%= itemSelectorViewDisplayContext.getSelectedGroupIds() %>"
	showSearch="<%= itemSelectorViewDisplayContext.isShowSearch() %>"
/>