<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
long accountEntryId = ParamUtil.getLong(request, "accountEntryId");

SearchContainer organizationSearchContainer = AssignableAccountOrganizationSearchContainerFactory.create(accountEntryId, liferayPortletRequest, liferayPortletResponse);

SelectAccountOrganizationsManagementToolbarDisplayContext selectAccountOrganizationsManagementToolbarDisplayContext = new SelectAccountOrganizationsManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, organizationSearchContainer);
%>

<clay:management-toolbar
	displayContext="<%= selectAccountOrganizationsManagementToolbarDisplayContext %>"
/>

<aui:container cssClass="container-fluid container-fluid-max-xl">
	<liferay-ui:search-container
		searchContainer="<%= organizationSearchContainer %>"
	>
		<liferay-ui:search-container-row
			className="com.liferay.portal.kernel.model.Organization"
			keyProperty="organizationId"
			modelVar="organization"
		>
			<liferay-ui:search-container-column-text
				cssClass="table-cell-expand-small table-cell-minw-150"
				name="name"
				property="name"
			/>

			<liferay-ui:search-container-column-text
				cssClass="table-cell-expand-small table-cell-minw-150"
				name="parent-organization"
				property="parentOrganizationName"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			markupView="lexicon"
		/>
	</liferay-ui:search-container>
</aui:container>

<aui:script use="liferay-search-container">
	var searchContainer = Liferay.SearchContainer.get(
		'<portlet:namespace />organizations'
	);

	searchContainer.on('rowToggled', function(event) {
		var selectedItems = event.elements.allSelectedElements;

		var result = {};

		if (!selectedItems.isEmpty()) {
			result = {
				data: {
					value: selectedItems.get('value').join(','),
				},
			};
		}

		Liferay.Util.getOpener().Liferay.fire(
			'<%= HtmlUtil.escapeJS(renderResponse.getNamespace() + "assignAccountOrganizations") %>',
			result
		);
	});
</aui:script>