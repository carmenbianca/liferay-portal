<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
SearchContainer accountEntryDisplaySearchContainer = AccountEntryDisplaySearchContainerFactory.create(liferayPortletRequest, liferayPortletResponse);

accountEntryDisplaySearchContainer.setRowChecker(null);

SelectAccountEntryManagementToolbarDisplayContext selectAccountEntryManagementToolbarDisplayContext = new SelectAccountEntryManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, accountEntryDisplaySearchContainer);
%>

<clay:management-toolbar
	displayContext="<%= selectAccountEntryManagementToolbarDisplayContext %>"
/>

<aui:container cssClass="container-fluid container-fluid-max-xl" id="selectAccountEntry">
	<liferay-ui:search-container
		searchContainer="<%= accountEntryDisplaySearchContainer %>"
	>
		<liferay-ui:search-container-row
			className="com.liferay.account.admin.web.internal.display.AccountEntryDisplay"
			keyProperty="accountEntryId"
			modelVar="accountEntryDisplay"
		>
			<liferay-ui:search-container-column-text
				cssClass="table-cell-expand table-title"
				name="name"
				property="name"
			/>

			<liferay-ui:search-container-column-text
				cssClass="table-cell-expand"
				name="parent-account"
				property="parentAccountEntryName"
			/>

			<liferay-ui:search-container-column-text>

				<%
				Map<String, Object> data = HashMapBuilder.<String, Object>put(
					"accountentryid", accountEntryDisplay.getAccountEntryId()
				).put(
					"entityid", accountEntryDisplay.getAccountEntryId()
				).put(
					"entityname", accountEntryDisplay.getName()
				).build();
				%>

				<aui:button cssClass="choose-account selector-button" data="<%= data %>" value="choose" />
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			markupView="lexicon"
		/>
	</liferay-ui:search-container>
</aui:container>

<aui:script>
	Liferay.Util.selectEntityHandler(
		'#<portlet:namespace />selectAccountEntry',
		'<%= HtmlUtil.escapeJS(liferayPortletResponse.getNamespace() + "selectAccountEntry") %>'
	);
</aui:script>