<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
SelectRolesDisplayContext selectRolesDisplayContext = new SelectRolesDisplayContext(request, renderRequest, renderResponse);
%>

<clay:management-toolbar
	displayContext="<%= new SelectRolesManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, selectRolesDisplayContext) %>"
/>

<aui:form cssClass="container-fluid-1280 portlet-site-memberships-assign-roles" name="fm">
	<liferay-ui:search-container
		id="roles"
		searchContainer="<%= selectRolesDisplayContext.getRoleSearchSearchContainer() %>"
	>
		<liferay-ui:search-container-row
			className="com.liferay.portal.kernel.model.Role"
			escapedModel="<%= true %>"
			keyProperty="roleId"
			modelVar="role"
		>

			<%
			Map<String, Object> data = HashMapBuilder.<String, Object>put(
				"id", role.getRoleId()
			).build();
			%>

			<c:choose>
				<c:when test='<%= Objects.equals(selectRolesDisplayContext.getDisplayStyle(), "icon") %>'>

					<%
					row.setCssClass("entry-card lfr-asset-item");
					%>

					<liferay-ui:search-container-column-text>
						<clay:vertical-card
							verticalCard="<%= new SelectRoleVerticalCard(role, renderRequest) %>"
						/>
					</liferay-ui:search-container-column-text>
				</c:when>
				<c:when test='<%= Objects.equals(selectRolesDisplayContext.getDisplayStyle(), "descriptive") %>'>
					<liferay-ui:search-container-column-text
						colspan="<%= 2 %>"
					>
						<h5>
							<aui:a cssClass="selector-button" data="<%= data %>" href="javascript:;">
								<%= HtmlUtil.escape(role.getTitle(locale)) %>
							</aui:a>
						</h5>

						<h6 class="text-default">
							<span><%= HtmlUtil.escape(role.getDescription(locale)) %></span>
						</h6>

						<h6 class="text-default">
							<%= LanguageUtil.get(request, role.getTypeLabel()) %>
						</h6>
					</liferay-ui:search-container-column-text>
				</c:when>
				<c:when test='<%= Objects.equals(selectRolesDisplayContext.getDisplayStyle(), "list") %>'>
					<liferay-ui:search-container-column-text
						cssClass="table-cell-content"
						name="title"
						truncate="<%= true %>"
					>
						<aui:a cssClass="selector-button" data="<%= data %>" href="javascript:;">
							<%= HtmlUtil.escape(role.getTitle(locale)) %>
						</aui:a>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						cssClass="table-cell-content"
						name="description"
						value="<%= HtmlUtil.escape(role.getDescription(locale)) %>"
					/>

					<liferay-ui:search-container-column-text
						name="type"
						value="<%= LanguageUtil.get(request, role.getTypeLabel()) %>"
					/>
				</c:when>
			</c:choose>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			displayStyle="<%= selectRolesDisplayContext.getDisplayStyle() %>"
			markupView="lexicon"
		/>
	</liferay-ui:search-container>
</aui:form>

<aui:script>
	Liferay.Util.selectEntityHandler(
		'#<portlet:namespace />fm',
		'<%= HtmlUtil.escapeJS(selectRolesDisplayContext.getEventName()) %>'
	);
</aui:script>