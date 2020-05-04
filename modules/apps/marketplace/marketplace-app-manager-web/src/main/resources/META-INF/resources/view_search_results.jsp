<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String redirect = PortalUtil.escapeRedirect(ParamUtil.getString(request, "redirect"));

if (Validator.isNull(redirect)) {
	redirect = String.valueOf(renderResponse.createRenderURL());
}

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(redirect);

PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(request, "app-manager"), String.valueOf(renderResponse.createRenderURL()));
PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(request, "search-results"), null);
%>

<portlet:renderURL var="viewURL" />

<clay:navigation-bar
	inverted="<%= true %>"
	navigationItems='<%= appManagerDisplayContext.getNavigationItems(viewURL, "search") %>'
/>

<%
AppManagerSearchResultsManagementToolbarDisplayContext
	appManagerSearchResultsManagementToolbarDisplayContext = new AppManagerSearchResultsManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse);

SearchContainer searchContainer = appManagerSearchResultsManagementToolbarDisplayContext.getSearchContainer();
%>

<clay:management-toolbar
	clearResultsURL="<%= redirect %>"
	itemsTotal="<%= searchContainer.getTotal() %>"
	searchActionURL="<%= appManagerSearchResultsManagementToolbarDisplayContext.getSearchActionURL() %>"
	searchContainerId="appDisplays"
	searchFormName="searchFm"
	selectable="<%= false %>"
	showSearch="<%= true %>"
	sortingOrder="<%= searchContainer.getOrderByType() %>"
	sortingURL="<%= appManagerSearchResultsManagementToolbarDisplayContext.getSortingURL() %>"
/>

<div class="container-fluid container-fluid-max-xl">
	<liferay-ui:breadcrumb
		showCurrentGroup="<%= false %>"
		showGuestGroup="<%= false %>"
		showLayout="<%= false %>"
		showParentGroups="<%= false %>"
	/>

	<liferay-ui:search-container
		id="appDisplays"
		searchContainer="<%= searchContainer %>"
		var="appDisplaySearch"
	>
		<liferay-ui:search-container-row
			className="Object"
			modelVar="result"
		>
			<c:choose>
				<c:when test="<%= result instanceof AppDisplay %>">

					<%
					AppDisplay appDisplay = (AppDisplay)result;
					%>

					<%@ include file="/app_display_columns.jspf" %>
				</c:when>
				<c:when test="<%= result instanceof Bundle %>">

					<%
					Bundle bundle = (Bundle)result;

					String app = StringPool.BLANK;
					%>

					<%@ include file="/bundle_columns.jspf" %>
				</c:when>
			</c:choose>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			displayStyle="descriptive"
			markupView="lexicon"
			resultRowSplitter="<%= new MarketplaceAppManagerResultRowSplitter() %>"
		/>
	</liferay-ui:search-container>
</div>