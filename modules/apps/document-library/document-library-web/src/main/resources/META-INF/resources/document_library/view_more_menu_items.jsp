<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/document_library/init.jsp" %>

<%
long folderId = ParamUtil.getLong(request, "folderId");

DLViewMoreMenuItemsDisplayContext dlViewMoreMenuItemsDisplayContext = new DLViewMoreMenuItemsDisplayContext(folderId, renderRequest, renderResponse);
%>

<clay:navigation-bar
	navigationItems="<%= dlViewMoreMenuItemsDisplayContext.getNavigationItems() %>"
/>

<clay:management-toolbar
	clearResultsURL="<%= dlViewMoreMenuItemsDisplayContext.getClearResultsURL() %>"
	componentId="dlViewMoreMenuItemsManagementToolbar"
	disabled="<%= dlViewMoreMenuItemsDisplayContext.getTotalItems() == 0 %>"
	itemsTotal="<%= dlViewMoreMenuItemsDisplayContext.getTotalItems() %>"
	searchActionURL="<%= dlViewMoreMenuItemsDisplayContext.getSearchActionURL() %>"
	searchFormName="fm"
	selectable="<%= false %>"
/>

<aui:form cssClass="container-fluid-1280" name="addMenuItemFm">
	<liferay-ui:search-container
		searchContainer="<%= dlViewMoreMenuItemsDisplayContext.getSearchContainer() %>"
	>
		<liferay-ui:search-container-row
			className="com.liferay.document.library.kernel.model.DLFileEntryType"
			escapedModel="<%= true %>"
			keyProperty="fileEntryTypeId"
			modelVar="fileEntryType"
		>

			<%
			Map<String, Object> data = HashMapBuilder.<String, Object>put(
				"fileEntryTypeId", String.valueOf(fileEntryType.getFileEntryTypeId())
			).build();
			%>

			<liferay-ui:search-container-column-text
				name="name"
			>
				<aui:a cssClass="selector-button" data="<%= data %>" href="javascript:;">
					<%= HtmlUtil.escape(fileEntryType.getName(locale)) %>
				</aui:a>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text
				name="description"
				value="<%= HtmlUtil.escape(fileEntryType.getDescription(locale)) %>"
			/>

			<liferay-ui:search-container-column-date
				name="modified-date"
				value="<%= fileEntryType.getModifiedDate() %>"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			markupView="lexicon"
		/>
	</liferay-ui:search-container>
</aui:form>

<aui:script use="aui-base">
	var Util = Liferay.Util;

	A.one('#<portlet:namespace />addMenuItemFm').delegate(
		'click',
		function(event) {
			Util.getOpener().Liferay.fire(
				'<%= HtmlUtil.escapeJS(dlViewMoreMenuItemsDisplayContext.getEventName()) %>',
				{
					fileEntryTypeId: event.currentTarget.attr(
						'data-fileEntryTypeId'
					),
				}
			);

			Util.getWindow().destroy();
		},
		'.selector-button'
	);
</aui:script>