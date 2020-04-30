<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/announcements/init.jsp" %>

<%
PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("mvcRenderCommandName", "/announcements/view");
portletURL.setParameter("tabs1", announcementsRequestHelper.getTabs1());
%>

<c:if test="<%= announcementsDisplayContext.isTabs1Visible() %>">
	<liferay-ui:tabs
		names="<%= announcementsDisplayContext.getTabs1Names() %>"
		url="<%= announcementsDisplayContext.getTabs1PortletURL() %>"
	/>
</c:if>

<c:if test="<%= PortletPermissionUtil.hasControlPanelAccessPermission(permissionChecker, scopeGroupId, AnnouncementsPortletKeys.ANNOUNCEMENTS_ADMIN) %>">
	<div class="button-holder">
		<portlet:renderURL var="addEntryURL">
			<portlet:param name="mvcRenderCommandName" value="/announcements/edit_entry" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="alert" value="<%= String.valueOf(portletName.equals(AnnouncementsPortletKeys.ALERTS)) %>" />
		</portlet:renderURL>

		<aui:button href="<%= addEntryURL %>" icon="icon-plus" value='<%= portletName.equals(AnnouncementsPortletKeys.ALERTS) ? "add-alert" : "add-announcement" %>' />
	</div>
</c:if>

<%@ include file="/announcements/view_entries.jspf" %>