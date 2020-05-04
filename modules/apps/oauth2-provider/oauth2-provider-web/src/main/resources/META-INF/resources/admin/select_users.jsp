<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/admin/init.jsp" %>

<%
SelectUsersDisplayContext selectUsersDisplayContext = new SelectUsersDisplayContext(request, renderRequest, renderResponse);
%>

<clay:management-toolbar
	displayContext="<%= new SelectUsersManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, selectUsersDisplayContext) %>"
/>

<aui:form cssClass="container-fluid-1280" name="selectUser">
	<liferay-ui:search-container
		id="users"
		searchContainer="<%= selectUsersDisplayContext.getUserSearchContainer() %>"
	>
		<liferay-ui:search-container-row
			className="com.liferay.portal.kernel.model.User"
			escapedModel="<%= true %>"
			keyProperty="userId"
			modelVar="userRow"
			rowIdProperty="screenName"
		>
			<liferay-ui:search-container-column-text
				cssClass="table-cell-expand table-cell-minw-200 table-title"
				name="screen-name"
				orderable="<%= true %>"
			>

				<%
				Map<String, Object> data = HashMapBuilder.<String, Object>put(
					"screenname", userRow.getScreenName()
				).put(
					"userid", userRow.getUserId()
				).build();
				%>

				<aui:a cssClass="selector-button" data="<%= data %>" href="javascript:;">
					<%= userRow.getScreenName() %>
				</aui:a>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text
				cssClass="table-cell-expand table-cell-minw-200"
				name="name"
				orderable="<%= true %>"
				property="fullName"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			displayStyle="<%= selectUsersDisplayContext.getDisplayStyle() %>"
			markupView="lexicon"
		/>
	</liferay-ui:search-container>
</aui:form>

<aui:script>
	Liferay.Util.selectEntityHandler(
		'#<portlet:namespace />selectUser',
		'<%= HtmlUtil.escapeJS(selectUsersDisplayContext.getEventName()) %>'
	);
</aui:script>