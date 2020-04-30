<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
SiteNavigationMenuItemItemSelectorViewDisplayContext siteNavigationMenuItemItemSelectorViewDisplayContext = (SiteNavigationMenuItemItemSelectorViewDisplayContext)request.getAttribute(SiteNavigationItemSelectorWebKeys.SITE_NAVIGATION_MENU_ITEM_ITEM_SELECTOR_DISPLAY_CONTEXT);
%>

<c:choose>
	<c:when test="<%= siteNavigationMenuItemItemSelectorViewDisplayContext.isShowSelectSiteNavigationMenuItem() %>">

		<%
		Map<String, Object> data = HashMapBuilder.<String, Object>put(
			"itemSelectorSaveEvent", siteNavigationMenuItemItemSelectorViewDisplayContext.getItemSelectedEventName()
		).put(
			"namespace", liferayPortletResponse.getNamespace()
		).put(
			"nodes", siteNavigationMenuItemItemSelectorViewDisplayContext.getSiteNavigationMenuItemsJSONArray()
		).put(
			"pathThemeImages", themeDisplay.getPathThemeImages()
		).build();
		%>

		<div class="select-site-navigation-menu-item">
			<react:component
				data="<%= data %>"
				module="js/SelectSiteNavigationMenuItem.es"
			/>
		</div>
	</c:when>
	<c:otherwise>
		<liferay-frontend:empty-result-message
			elementType='<%= LanguageUtil.get(resourceBundle, "navigation-menu-items") %>'
		/>
	</c:otherwise>
</c:choose>