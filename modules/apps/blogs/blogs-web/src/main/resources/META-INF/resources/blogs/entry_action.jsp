<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
BlogsEntry entry = (BlogsEntry)request.getAttribute("view_entry_content.jsp-entry");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

if (row != null) {
	entry = (BlogsEntry)row.getObject();
}
%>

<liferay-ui:icon-menu
	cssClass='<%= (row == null) ? "entry-options inline" : StringPool.BLANK %>'
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="actions"
	showWhenSingleIcon="<%= true %>"
>
	<c:if test="<%= BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.UPDATE) %>">

		<%
		PortletURL editEntryURL = PortalUtil.getControlPanelPortletURL(request, themeDisplay.getScopeGroup(), BlogsPortletKeys.BLOGS_ADMIN, 0, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);

		editEntryURL.setParameter("mvcRenderCommandName", "/blogs/edit_entry");
		editEntryURL.setParameter("redirect", currentURL);
		editEntryURL.setParameter("portletResource", portletDisplay.getId());
		editEntryURL.setParameter("entryId", String.valueOf(entry.getEntryId()));
		%>

		<liferay-ui:icon
			label="<%= true %>"
			message="edit"
			url="<%= editEntryURL.toString() %>"
		/>
	</c:if>

	<c:if test="<%= BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="<%= BlogsEntry.class.getName() %>"
			modelResourceDescription="<%= BlogsEntryUtil.getDisplayTitle(resourceBundle, entry) %>"
			resourceGroupId="<%= String.valueOf(entry.getGroupId()) %>"
			resourcePrimKey="<%= String.valueOf(entry.getEntryId()) %>"
			var="permissionsEntryURL"
			windowState="<%= LiferayWindowState.POP_UP.toString() %>"
		/>

		<liferay-ui:icon
			label="<%= true %>"
			message="permissions"
			method="get"
			url="<%= permissionsEntryURL %>"
			useDialog="<%= true %>"
		/>
	</c:if>

	<c:if test="<%= BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.DELETE) %>">
		<portlet:renderURL var="viewEntriesURL" />

		<portlet:actionURL name="/blogs/edit_entry" var="deleteEntryURL">
			<portlet:param name="<%= Constants.CMD %>" value="<%= trashHelper.isTrashEnabled(scopeGroupId) ? Constants.MOVE_TO_TRASH : Constants.DELETE %>" />
			<portlet:param name="redirect" value="<%= viewEntriesURL %>" />
			<portlet:param name="entryId" value="<%= String.valueOf(entry.getEntryId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete
			label="<%= true %>"
			trash="<%= trashHelper.isTrashEnabled(scopeGroupId) %>"
			url="<%= deleteEntryURL %>"
		/>
	</c:if>
</liferay-ui:icon-menu>