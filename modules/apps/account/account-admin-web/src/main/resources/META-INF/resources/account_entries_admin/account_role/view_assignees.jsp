<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
long accountEntryId = ParamUtil.getLong(request, "accountEntryId");

long accountRoleId = ParamUtil.getLong(request, "accountRoleId");

AccountRole accountRole = AccountRoleLocalServiceUtil.fetchAccountRole(accountRoleId);

Role role = null;

if (accountRole != null) {
	role = accountRole.getRole();
}

SearchContainer accountRoleUserDisplaySearchContainer = AccountUserDisplaySearchContainerFactory.create(accountEntryId, role.getRoleId(), liferayPortletRequest, liferayPortletResponse);

ViewAccountRoleAssigneesManagementToolbarDisplayContext viewAccountRoleAssigneesManagementToolbarDisplayContext = new ViewAccountRoleAssigneesManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, accountRoleUserDisplaySearchContainer);
%>

<clay:management-toolbar
	displayContext="<%= viewAccountRoleAssigneesManagementToolbarDisplayContext %>"
/>

<aui:container cssClass="container-fluid container-fluid-max-xl">
	<aui:form method="post" name="fm">
		<aui:input name="accountEntryId" type="hidden" value="<%= accountEntryId %>" />
		<aui:input name="accountRoleId" type="hidden" value="<%= accountRoleId %>" />
		<aui:input name="accountUserIds" type="hidden" />

		<liferay-ui:search-container
			searchContainer="<%= accountRoleUserDisplaySearchContainer %>"
		>
			<liferay-ui:search-container-row
				className="com.liferay.account.admin.web.internal.display.AccountUserDisplay"
				keyProperty="userId"
				modelVar="accountUser"
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
					name="job-title"
					property="jobTitle"
				/>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator
				markupView="lexicon"
			/>
		</liferay-ui:search-container>
	</aui:form>
</aui:container>

<liferay-frontend:component
	componentId="<%= viewAccountRoleAssigneesManagementToolbarDisplayContext.getDefaultEventHandler() %>"
	module="account_entries_admin/js/AccountUsersManagementToolbarDefaultEventHandler.es"
/>