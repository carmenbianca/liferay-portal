<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
RoleItemSelectorViewDisplayContext roleItemSelectorViewDisplayContext = (RoleItemSelectorViewDisplayContext)request.getAttribute(RoleItemSelectorViewConstants.ROLE_ITEM_SELECTOR_VIEW_DISPLAY_CONTEXT);
%>

<clay:management-toolbar
	displayContext="<%= roleItemSelectorViewDisplayContext %>"
/>

<div class="container-fluid container-fluid-max-xl container-form-lg container-view" id="<portlet:namespace />roleSelectorWrapper">
	<liferay-ui:search-container
		searchContainer="<%= roleItemSelectorViewDisplayContext.getSearchContainer() %>"
	>
		<liferay-ui:search-container-row
			className="com.liferay.portal.kernel.model.Role"
			cssClass="entry"
			keyProperty="roleId"
			modelVar="role"
		>

			<%
			String cssClass = "table-cell-content";

			RowChecker rowChecker = searchContainer.getRowChecker();

			if ((rowChecker != null) && rowChecker.isDisabled(role)) {
				cssClass += " text-muted";
			}
			%>

			<liferay-ui:search-container-column-text
				cssClass="<%= cssClass %>"
				property="name"
			/>

			<liferay-ui:search-container-column-text
				cssClass="<%= cssClass %>"
				property="description"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			displayStyle="list"
			markupView="lexicon"
		/>
	</liferay-ui:search-container>
</div>

<aui:script require="metal-dom/src/all/dom as dom">
	var selectItemHandler = dom.delegate(
		document.getElementById('<portlet:namespace />roleSelectorWrapper'),
		'change',
		'.entry input',
		function(event) {
			var checked = Liferay.Util.listCheckedExcept(
				document.getElementById(
					'<portlet:namespace /><%= roleItemSelectorViewDisplayContext.getSearchContainerId() %>'
				),
				'<portlet:namespace />allRowIds'
			);

			Liferay.Util.getOpener().Liferay.fire(
				'<%= HtmlUtil.escapeJS(roleItemSelectorViewDisplayContext.getItemSelectedEventName()) %>',
				{
					data: {
						value: checked,
					},
				}
			);
		}
	);

	Liferay.on('destroyPortlet', function removeListener() {
		selectItemHandler.removeListener();

		Liferay.detach('destroyPortlet', removeListener);
	});
</aui:script>