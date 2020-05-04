<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
ContributedFragmentManagementToolbarDisplayContext contributedFragmentManagementToolbarDisplayContext = new ContributedFragmentManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, fragmentDisplayContext);
%>

<clay:management-toolbar
	displayContext="<%= contributedFragmentManagementToolbarDisplayContext %>"
/>

<aui:form name="fm">
	<liferay-ui:search-container
		searchContainer="<%= fragmentDisplayContext.getContributedFragmentEntriesSearchContainer() %>"
	>
		<liferay-ui:search-container-row
			className="com.liferay.fragment.model.FragmentEntry"
			keyProperty="fragmentEntryKey"
			modelVar="fragmentEntry"
		>

			<%
			row.setCssClass("card-page-item-asset " + row.getCssClass());
			%>

			<liferay-ui:search-container-column-text>
				<clay:vertical-card
					verticalCard="<%= new ContributedFragmentEntryVerticalCard(fragmentEntry, renderRequest, renderResponse, searchContainer.getRowChecker()) %>"
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

<aui:form name="fragmentEntryFm">
	<aui:input name="fragmentEntryKeys" type="hidden" />
	<aui:input name="fragmentCollectionId" type="hidden" />
</aui:form>

<liferay-frontend:component
	componentId="<%= FragmentWebKeys.FRAGMENT_ENTRY_DROPDOWN_DEFAULT_EVENT_HANDLER %>"
	module="js/FragmentEntryDropdownDefaultEventHandler.es"
/>

<liferay-frontend:component
	componentId="<%= contributedFragmentManagementToolbarDisplayContext.getDefaultEventHandler() %>"
	context="<%= contributedFragmentManagementToolbarDisplayContext.getComponentContext() %>"
	module="js/ManagementToolbarDefaultEventHandler.es"
/>