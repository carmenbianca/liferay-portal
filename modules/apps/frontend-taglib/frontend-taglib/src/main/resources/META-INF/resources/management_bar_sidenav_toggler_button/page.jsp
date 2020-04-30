<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/management_bar_sidenav_toggler_button/init.jsp" %>

<liferay-frontend:management-bar-button
	active="<%= false %>"
	cssClass="<%= cssClass %>"
	data="<%= data %>"
	disabled="<%= disabled %>"
	href="<%= href %>"
	icon="<%= icon %>"
	iconCssClass="<%= iconCssClass %>"
	id="<%= id %>"
	label="<%= label %>"
/>

<aui:script>
	var sidenavToggle = document.querySelector('[href="#<%= sidenavId %>"]');

	if (!Liferay.SideNavigation.instance(sidenavToggle)) {
		var sidenavInstance = Liferay.SideNavigation.initialize(sidenavToggle, {
			position: '<%= position %>',
			type: '<%= type %>',
			typeMobile: '<%= typeMobile %>',
			width: '<%= width %>',
		});

		sidenavInstance.on('closed.lexicon.sidenav', function(event) {
			Liferay.Util.Session.set(
				'com.liferay.info.panel_<%= sidenavId %>',
				'closed'
			);
		});

		sidenavInstance.on('open.lexicon.sidenav', function(event) {
			Liferay.Util.Session.set(
				'com.liferay.info.panel_<%= sidenavId %>',
				'open'
			);
		});
	}
</aui:script>