<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
SelectFragmentCollectionDisplayContext selectFragmentCollectionDisplayContext = new SelectFragmentCollectionDisplayContext(request, renderRequest, renderResponse);

SelectFragmentCollectionManagementToolbarDisplayContext selectFragmentCollectionManagementToolbarDisplayContext = new SelectFragmentCollectionManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, selectFragmentCollectionDisplayContext.getFragmentCollectionsSearchContainer());
%>

<clay:management-toolbar
	displayContext="<%= selectFragmentCollectionManagementToolbarDisplayContext %>"
/>

<aui:form cssClass="container-fluid-1280" name="selectFragmentCollectionFm">
	<liferay-ui:search-container
		searchContainer="<%= selectFragmentCollectionDisplayContext.getFragmentCollectionsSearchContainer() %>"
	>
		<liferay-ui:search-container-row
			className="com.liferay.fragment.model.FragmentCollection"
			keyProperty="fragmentCollectionId"
			modelVar="fragmentCollection"
		>

			<%
			row.setCssClass("card-page-item-asset " + row.getCssClass());
			%>

			<liferay-ui:search-container-column-text>
				<clay:horizontal-card
					horizontalCard="<%= new FragmentCollectionHorizontalCard(fragmentCollection) %>"
				/>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			displayStyle="icon"
			markupView="lexicon"
			searchResultCssClass="card-page"
		/>
	</liferay-ui:search-container>
</aui:form>

<aui:script>
	Liferay.Util.selectEntityHandler(
		'#<portlet:namespace />selectFragmentCollectionFm',
		'<%= HtmlUtil.escapeJS(selectFragmentCollectionDisplayContext.getEventName()) %>'
	);
</aui:script>