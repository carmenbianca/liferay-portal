<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
SearchContainer accountEntryDisplaySearchContainer = AccountEntryDisplaySearchContainerFactory.create(liferayPortletRequest, liferayPortletResponse);

ViewAccountEntriesManagementToolbarDisplayContext viewAccountEntriesManagementToolbarDisplayContext = new ViewAccountEntriesManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, accountEntryDisplaySearchContainer);
%>

<clay:management-toolbar
	displayContext="<%= viewAccountEntriesManagementToolbarDisplayContext %>"
/>

<div class="container-fluid container-fluid-max-xl">
	<aui:form method="post" name="fm">
		<aui:input name="accountEntryIds" type="hidden" />

		<liferay-ui:search-container
			searchContainer="<%= accountEntryDisplaySearchContainer %>"
		>
			<liferay-ui:search-container-row
				className="com.liferay.account.admin.web.internal.display.AccountEntryDisplay"
				keyProperty="accountEntryId"
				modelVar="accountEntryDisplay"
			>

				<%
				Map<String, Object> rowData = HashMapBuilder.<String, Object>put(
					"actions", StringUtil.merge(viewAccountEntriesManagementToolbarDisplayContext.getAvailableActions(accountEntryDisplay))
				).build();

				row.setData(rowData);
				%>

				<portlet:renderURL var="rowURL">
					<portlet:param name="mvcRenderCommandName" value="/account_admin/edit_account_entry" />
					<portlet:param name="backURL" value="<%= currentURL %>" />
					<portlet:param name="accountEntryId" value="<%= String.valueOf(accountEntryDisplay.getAccountEntryId()) %>" />
				</portlet:renderURL>

				<%
				if (!AccountEntryPermission.contains(permissionChecker, accountEntryDisplay.getAccountEntryId(), ActionKeys.UPDATE)) {
					rowURL = null;
				}
				%>

				<liferay-ui:search-container-column-text
					cssClass="table-cell-expand table-title"
					href="<%= rowURL %>"
					name="name"
					property="name"
				/>

				<liferay-ui:search-container-column-text
					cssClass="table-cell-expand"
					href="<%= rowURL %>"
					name="parent-account"
					property="parentAccountEntryName"
				/>

				<liferay-ui:search-container-column-text
					cssClass="table-cell-expand"
					href="<%= rowURL %>"
					name="account-owner"
					value=""
				/>

				<liferay-ui:search-container-column-text
					cssClass="table-cell-expand"
					name="status"
				>
					<clay:label
						label="<%= StringUtil.toUpperCase(LanguageUtil.get(request, accountEntryDisplay.getStatusLabel()), locale) %>"
						style="<%= accountEntryDisplay.getStatusLabelStyle() %>"
					/>
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-jsp
					path="/account_entries_admin/account_entry_action.jsp"
				/>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator
				markupView="lexicon"
			/>
		</liferay-ui:search-container>
	</aui:form>
</div>

<liferay-frontend:component
	componentId="<%= viewAccountEntriesManagementToolbarDisplayContext.getDefaultEventHandler() %>"
	module="account_entries_admin/js/AccountEntriesManagementToolbarDefaultEventHandler.es"
/>