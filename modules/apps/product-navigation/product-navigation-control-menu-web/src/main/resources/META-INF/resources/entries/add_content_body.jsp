<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<liferay-util:body-bottom
	outputKey="addContentMenu"
>

	<%
	String portletNamespace = PortalUtil.getPortletNamespace(ProductNavigationControlMenuPortletKeys.PRODUCT_NAVIGATION_CONTROL_MENU);
	%>

	<div class="closed d-print-none lfr-add-panel lfr-admin-panel sidenav-fixed sidenav-menu-slider sidenav-right" id="<%= portletNamespace %>addPanelId">
		<div class="product-menu sidebar sidebar-inverse sidenav-menu">
			<div class="sidebar-header">
				<h1 class="sr-only"><liferay-ui:message key="widget-selection-panel" /></h1>

				<span><liferay-ui:message key="add" /></span>

				<a aria-label="<%= LanguageUtil.get(request, "close") %>" class="sidenav-close" href="javascript:;">
					<aui:icon cssClass="icon-monospaced" image="times" markupView="lexicon" />
				</a>
			</div>

			<div class="sidebar-body"></div>
		</div>
	</div>

	<aui:script>
		var addToggle = document.getElementById('<%= portletNamespace %>addToggleId');

		Liferay.SideNavigation.initialize(addToggle);

		Liferay.once('screenLoad', function() {
			Liferay.SideNavigation.destroy(addToggle);
		});
	</aui:script>
</liferay-util:body-bottom>