<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
long accountEntryId = ParamUtil.getLong(request, "accountEntryId");

SearchContainer userSearchContainer = AssignableAccountUserDisplaySearchContainerFactory.create(accountEntryId, liferayPortletRequest, liferayPortletResponse);

SelectAccountUsersManagementToolbarDisplayContext selectAccountUsersManagementToolbarDisplayContext = new SelectAccountUsersManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, userSearchContainer);
%>

<clay:management-toolbar
	displayContext="<%= selectAccountUsersManagementToolbarDisplayContext %>"
/>

<aui:container cssClass="container-fluid container-fluid-max-xl">
	<c:if test='<%= !Objects.equals(selectAccountUsersManagementToolbarDisplayContext.getNavigation(), "all-users") %>'>
		<clay:alert
			message='<%= LanguageUtil.get(request, "showing-users-with-valid-domains-only") %>'
			title='<%= LanguageUtil.get(request, "info") %>'
		/>
	</c:if>

	<liferay-ui:search-container
		searchContainer="<%= userSearchContainer %>"
	>
		<liferay-ui:search-container-row
			className="com.liferay.account.admin.web.internal.display.AccountUserDisplay"
			keyProperty="userId"
			modelVar="accountUserDisplay"
		>
			<liferay-ui:search-container-column-text
				cssClass="table-cell-expand-small table-cell-minw-150"
				name="name"
				property="name"
			/>

			<liferay-ui:search-container-column-text
				cssClass="table-cell-expand-small table-cell-minw-150"
				name="email-address"
				property="emailAddress"
			/>

			<liferay-ui:search-container-column-text
				cssClass="table-cell-expand-small table-cell-minw-150"
				name="account-roles"
				value="<%= accountUserDisplay.getAccountRoleNames(accountEntryId, locale) %>"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			markupView="lexicon"
		/>
	</liferay-ui:search-container>
</aui:container>

<aui:script use="liferay-search-container">
	var searchContainer = Liferay.SearchContainer.get(
		'<portlet:namespace />accountUsers'
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
			'<%= HtmlUtil.escapeJS(renderResponse.getNamespace() + "assignAccountUsers") %>',
			result
		);
	});
</aui:script>