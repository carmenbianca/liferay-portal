<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/init.jsp" %>

<%
SearchContainer<AccountEntryDisplay> accountEntryDisplaySearchContainer = AccountEntryDisplaySearchContainerFactory.create(liferayPortletRequest, liferayPortletResponse);

accountEntryDisplaySearchContainer.setRowChecker(null);

SelectAccountEntryManagementToolbarDisplayContext selectAccountEntryManagementToolbarDisplayContext = new SelectAccountEntryManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, accountEntryDisplaySearchContainer);
%>

<clay:management-toolbar
	displayContext="<%= selectAccountEntryManagementToolbarDisplayContext %>"
/>

<clay:container
	id='<%= renderResponse.getNamespace() + "selectAccountEntry" %>'
>
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
</clay:container>

<aui:script>
	Liferay.Util.selectEntityHandler(
		'#<portlet:namespace />selectAccountEntry',
		'<%= HtmlUtil.escapeJS(liferayPortletResponse.getNamespace() + "selectAccountEntry") %>'
	);
</aui:script>