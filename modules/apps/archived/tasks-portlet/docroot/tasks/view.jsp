<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String tabs1 = ParamUtil.getString(request, "tabs1", tabs1Default);
String tabs2 = ParamUtil.getString(request, "tabs2", "open");

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setWindowState(WindowState.NORMAL);

portletURL.setParameter("tabs1", tabs1);
portletURL.setParameter("tabs2", tabs2);
%>

<%@ include file="/tasks/tabs1.jspf" %>

<div class="control-wrapper">
	<c:if test="<%= TasksPermission.contains(permissionChecker, themeDisplay.getScopeGroupId(), ActionKeys.ADD_ENTRY) %>">
		<portlet:renderURL var="addkURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
			<portlet:param name="mvcPath" value="/tasks/edit_task.jsp" />
		</portlet:renderURL>

		<%
		String taglibOnClick = "Liferay.Tasks.displayPopup('" + addkURL.toString() + "', '" + LanguageUtil.get(request, "add-task") + "');";
		%>

		<liferay-ui:icon
			icon="plus"
			label="<%= true %>"
			markupView="lexicon"
			message="add-task"
			onClick="<%= taglibOnClick %>"
			url="javascript:;"
		/>
	</c:if>

	<c:if test="<%= TasksPermission.contains(permissionChecker, themeDisplay.getScopeGroupId(), ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="com.liferay.tasks"
			modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
			resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
			var="permissionsURL"
			windowState="<%= LiferayWindowState.POP_UP.toString() %>"
		/>

		<liferay-ui:icon
			icon="lock"
			label="<%= true %>"
			markupView="lexicon"
			message="permissions"
			method="get"
			url="<%= permissionsURL %>"
			useDialog="<%= true %>"
		/>
	</c:if>

	<liferay-ui:icon
		cssClass="filter-tasks"
		icon="tag"
		label="<%= true %>"
		markupView="lexicon"
		message="filter"
		onClick="Liferay.Tasks.toggleTasksFilter()"
		url="javascript:;"
	/>

	<div style="clear: both;"><!-- --></div>
</div>

<div class="filter-wrapper hide">
	<%@ include file="/tasks/view_tasks_filter.jspf" %>
</div>

<div class="list-wrapper">
	<liferay-util:include page="/tasks/view_tasks.jsp" servletContext="<%= application %>" />
</div>

<div class="tasks-options">
	<table>
		<tr>
			<td>
				<input name="all-tasks" onclick="Liferay.Tasks.updateTaskList(null, this.checked);" type="checkbox" <%= tabs2.equals("all") ? "checked" : StringPool.BLANK %> />
			</td>
			<td>
				<liferay-ui:message key="show-completed-tasks" />
			</td>
		</tr>
	</table>
</div>

<aui:script use="liferay-tasks">
	Liferay.Tasks.init(
		{
			baseActionURL: '<%= PortletURLFactoryUtil.create(request, portletDisplay.getId(), themeDisplay.getPlid(), PortletRequest.ACTION_PHASE) %>',
			currentTab: '<%= HtmlUtil.escape(tabs1) %>',
			namespace: '<portlet:namespace />',
			taskListURL: '<portlet:renderURL windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>"><portlet:param name="mvcPath" value="/tasks/view_tasks.jsp" /></portlet:renderURL>'
		}
	);
</aui:script>