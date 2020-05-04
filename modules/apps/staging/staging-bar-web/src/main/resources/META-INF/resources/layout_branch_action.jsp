<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

LayoutRevision rootLayoutRevision = (LayoutRevision)row.getObject();

LayoutBranch layoutBranch = rootLayoutRevision.getLayoutBranch();

long currentLayoutBranchId = GetterUtil.getLong((String)request.getAttribute("view_layout_branches.jsp-currentLayoutBranchId"));
%>

<liferay-ui:icon-menu
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>"
>
	<c:if test="<%= LayoutBranchPermissionUtil.contains(permissionChecker, layoutBranch, ActionKeys.UPDATE) %>">
		<liferay-portlet:renderURL var="editLayoutBranchURL">
			<portlet:param name="mvcRenderCommandName" value="editLayoutBranch" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="groupId" value="<%= String.valueOf(layoutBranch.getGroupId()) %>" />
			<portlet:param name="layoutBranchId" value="<%= String.valueOf(layoutBranch.getLayoutBranchId()) %>" />
		</liferay-portlet:renderURL>

		<liferay-ui:icon
			message="edit"
			url="<%= editLayoutBranchURL %>"
		/>

		<c:if test="<%= !rootLayoutRevision.isPending() && !layoutBranch.isMaster() && LayoutBranchPermissionUtil.contains(permissionChecker, layoutBranch, ActionKeys.DELETE) %>">
			<portlet:actionURL name="deleteLayoutBranch" var="deleteLayoutBranchURL">
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="groupId" value="<%= String.valueOf(layoutBranch.getGroupId()) %>" />
				<portlet:param name="layoutBranchId" value="<%= String.valueOf(layoutBranch.getLayoutBranchId()) %>" />
				<portlet:param name="currentLayoutBranchId" value="<%= String.valueOf(currentLayoutBranchId) %>" />
			</portlet:actionURL>

			<liferay-ui:icon-delete
				url="<%= deleteLayoutBranchURL %>"
			/>
		</c:if>
	</c:if>
</liferay-ui:icon-menu>