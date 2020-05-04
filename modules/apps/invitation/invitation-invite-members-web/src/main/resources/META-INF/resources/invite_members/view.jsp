<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);
%>

<c:choose>
	<c:when test="<%= group.isUser() %>">
		<liferay-ui:message key="this-application-will-only-function-when-placed-on-a-site-page" />
	</c:when>
	<c:when test="<%= GroupPermissionUtil.contains(permissionChecker, group.getGroupId(), ActionKeys.UPDATE) %>">
		<portlet:renderURL var="inviteURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
			<portlet:param name="mvcPath" value="/invite_members/view_invite.jsp" />
		</portlet:renderURL>

		<aui:a cssClass="btn btn-secondary" href="javascript:;" id="inviteMembersButton" label="invite-members" />

		<aui:script position="inline">
			var <portlet:namespace />inviteMembersButton = document.getElementById(
				'<portlet:namespace />inviteMembersButton'
			);

			<portlet:namespace />inviteMembersButton.addEventListener('click', function(
				event
			) {
				Liferay.Util.openWindow({
					dialog: {
						cssClass: 'so-portlet-invite-members',
						destroyOnHide: true,
						width: 700,
					},
					dialogIframe: {
						bodyCssClass: 'dialog-with-footer',
					},
					title: '<%= portletDisplay.getTitle() %>',
					uri: '<%= HtmlUtil.escapeJS(inviteURL) %>',
				});
			});
		</aui:script>
	</c:when>
	<c:otherwise>
		<aui:script require="metal-dom/src/dom">
			var dom = metalDomSrcDom.default;

			var portlet = document.getElementById('p_p_id<portlet:namespace />');

			if (portlet) {
				dom.addClasses(portlet, 'hide');
			}
		</aui:script>
	</c:otherwise>
</c:choose>