<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
LayoutPageTemplateCollectionsDisplayContext layoutPageTemplateCollectionsDisplayContext = new LayoutPageTemplateCollectionsDisplayContext(request, renderRequest, renderResponse);
%>

<clay:management-toolbar
	displayContext="<%= new LayoutPageTemplateCollectionsManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, layoutPageTemplateCollectionsDisplayContext) %>"
/>

<aui:form cssClass="container-fluid-1280" name="fm">
	<liferay-ui:search-container
		id="layoutPageTemplateCollections"
		searchContainer="<%= layoutPageTemplateCollectionsDisplayContext.getSearchContainer() %>"
	>
		<liferay-ui:search-container-row
			className="com.liferay.layout.page.template.model.LayoutPageTemplateCollection"
			keyProperty="layoutPageTemplateCollectionId"
			modelVar="layoutPageTemplateCollection"
		>
			<liferay-ui:search-container-column-text
				name="name"
				truncate="<%= true %>"
				value="<%= HtmlUtil.escape(layoutPageTemplateCollection.getName()) %>"
			/>

			<liferay-ui:search-container-column-date
				name="create-date"
				property="createDate"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			displayStyle="list"
			markupView="lexicon"
		/>
	</liferay-ui:search-container>
</aui:form>

<aui:script use="liferay-search-container">
	var searchContainer = Liferay.SearchContainer.get(
		'<portlet:namespace />layoutPageTemplateCollections'
	);

	searchContainer.on('rowToggled', function(event) {
		Liferay.Util.getOpener().Liferay.fire(
			'<%= HtmlUtil.escapeJS(layoutPageTemplateCollectionsDisplayContext.getEventName()) %>',
			{
				data: event.elements.allSelectedElements.getDOMNodes(),
			}
		);
	});
</aui:script>