<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
EditSiteTeamAssignmentsUserGroupsDisplayContext editSiteTeamAssignmentsUserGroupsDisplayContext = new EditSiteTeamAssignmentsUserGroupsDisplayContext(request, renderRequest, renderResponse);

EditSiteTeamAssignmentsUserGroupsManagementToolbarDisplayContext editSiteTeamAssignmentsUserGroupsManagementToolbarDisplayContext = new EditSiteTeamAssignmentsUserGroupsManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, editSiteTeamAssignmentsUserGroupsDisplayContext);
%>

<clay:navigation-bar
	inverted="<%= true %>"
	navigationItems="<%= editSiteTeamAssignmentsUserGroupsDisplayContext.getNavigationItems() %>"
/>

<clay:management-toolbar
	displayContext="<%= editSiteTeamAssignmentsUserGroupsManagementToolbarDisplayContext %>"
/>

<portlet:actionURL name="deleteTeamUserGroups" var="deleteTeamUserGroupsURL" />

<aui:form action="<%= deleteTeamUserGroupsURL %>" cssClass="container-fluid-1280" method="post" name="fm">
	<aui:input name="tabs1" type="hidden" value="<%= editSiteTeamAssignmentsUserGroupsDisplayContext.getTabs1() %>" />
	<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
	<aui:input name="teamId" type="hidden" value="<%= String.valueOf(editSiteTeamAssignmentsUserGroupsDisplayContext.getTeamId()) %>" />

	<liferay-ui:search-container
		id="userGroups"
		searchContainer="<%= editSiteTeamAssignmentsUserGroupsDisplayContext.getUserGroupSearchContainer() %>"
	>
		<liferay-ui:search-container-row
			className="com.liferay.portal.kernel.model.UserGroup"
			cssClass="selectable"
			escapedModel="<%= true %>"
			keyProperty="userGroupId"
			modelVar="userGroup"
		>

			<%
			LinkedHashMap<String, Object> userParams = LinkedHashMapBuilder.<String, Object>put(
				"usersUserGroups", Long.valueOf(userGroup.getUserGroupId())
			).build();

			int usersCount = UserLocalServiceUtil.searchCount(company.getCompanyId(), StringPool.BLANK, WorkflowConstants.STATUS_ANY, userParams);
			%>

			<c:choose>
				<c:when test='<%= Objects.equals(editSiteTeamAssignmentsUserGroupsDisplayContext.getDisplayStyle(), "descriptive") %>'>
					<liferay-ui:search-container-column-icon
						icon="users"
						toggleRowChecker="<%= true %>"
					/>

					<liferay-ui:search-container-column-text
						colspan="<%= 2 %>"
					>
						<h5><%= userGroup.getName() %></h5>

						<h6 class="text-default">
							<span><%= userGroup.getDescription() %></span>
						</h6>

						<h6 class="text-default">
							<span><liferay-ui:message arguments="<%= usersCount %>" key="x-users" /></span>
						</h6>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-jsp
						path="/edit_team_assignments_user_groups_action.jsp"
					/>
				</c:when>
				<c:otherwise>
					<liferay-ui:search-container-column-text
						cssClass="table-cell-content"
						name="name"
						orderable="<%= true %>"
						property="name"
					/>

					<liferay-ui:search-container-column-text
						cssClass="table-cell-content"
						name="description"
						orderable="<%= true %>"
						property="description"
					/>

					<liferay-ui:search-container-column-text
						name="users"
						value="<%= String.valueOf(usersCount) %>"
					/>

					<liferay-ui:search-container-column-jsp
						path="/edit_team_assignments_user_groups_action.jsp"
					/>
				</c:otherwise>
			</c:choose>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			displayStyle="<%= editSiteTeamAssignmentsUserGroupsDisplayContext.getDisplayStyle() %>"
			markupView="lexicon"
		/>
	</liferay-ui:search-container>
</aui:form>

<portlet:actionURL name="addTeamUserGroups" var="addTeamUserGroupsURL" />

<aui:form action="<%= addTeamUserGroupsURL %>" cssClass="hide" name="addTeamUserGroupsFm">
	<aui:input name="tabs1" type="hidden" value="<%= editSiteTeamAssignmentsUserGroupsDisplayContext.getTabs1() %>" />
	<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
	<aui:input name="teamId" type="hidden" value="<%= String.valueOf(editSiteTeamAssignmentsUserGroupsDisplayContext.getTeamId()) %>" />
</aui:form>

<liferay-frontend:component
	componentId="<%= editSiteTeamAssignmentsUserGroupsManagementToolbarDisplayContext.getDefaultEventHandler() %>"
	module="js/EditTeamAssignmentsUserGroupsManagementToolbarDefaultEventHandler.es"
/>