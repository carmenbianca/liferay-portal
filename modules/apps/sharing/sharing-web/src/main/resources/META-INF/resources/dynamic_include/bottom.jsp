<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/dynamic_include/init.jsp" %>

<%
PortletURL manageCollaboratorsURL = PortletProviderUtil.getPortletURL(request, SharingEntry.class.getName(), PortletProvider.Action.MANAGE);

manageCollaboratorsURL.setWindowState(LiferayWindowState.POP_UP);

PortletURL sharingURL = PortletProviderUtil.getPortletURL(request, SharingEntry.class.getName(), PortletProvider.Action.EDIT);

sharingURL.setWindowState(LiferayWindowState.POP_UP);
%>

<aui:script sandbox="<%= true %>">
	function showDialog(uri, title) {
		Liferay.Util.openWindow({
			dialog: {
				centered: true,
				constrain: true,
				cssClass: 'sharing-dialog',
				destroyOnHide: true,
				modal: true,
				height: 540,
				width: 600,
			},
			id: 'sharingDialog',
			title: Liferay.Util.escapeHTML(title),
			uri: uri,
		});
	}

	var Sharing = {};

	Liferay.provide(
		Sharing,
		'share',
		function(classNameId, classPK, title) {
			var sharingParameters = {
				classNameId: classNameId,
				classPK: classPK,
			};

			var sharingURL = Liferay.Util.PortletURL.createPortletURL(
				'<%= sharingURL.toString() %>',
				sharingParameters
			);

			showDialog(sharingURL.toString(), title);
		},
		['liferay-util-window']
	);

	Liferay.provide(
		Sharing,
		'manageCollaborators',
		function(classNameId, classPK) {
			var manageCollaboratorsParameters = {
				classNameId: classNameId,
				classPK: classPK,
			};

			var manageCollaboratorsURL = Liferay.Util.PortletURL.createPortletURL(
				'<%= manageCollaboratorsURL.toString() %>',
				manageCollaboratorsParameters
			);

			showDialog(
				manageCollaboratorsURL.toString(),
				'<%= LanguageUtil.get(resourceBundle, "manage-collaborators") %>'
			);
		},
		['liferay-util-window']
	);

	Liferay.Sharing = Sharing;
</aui:script>