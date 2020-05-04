<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
PortletURL portletURL = PortalUtil.getControlPanelPortletURL(request, liveGroup, StagingProcessesPortletKeys.STAGING_PROCESSES, 0, 0, PortletRequest.RENDER_PHASE);
%>

<liferay-ui:icon
	message="staging-configuration"
	onClick='<%= renderResponse.getNamespace() + "openStagingConfigurationPortlet();" %>'
	url="javascript:;"
/>

<liferay-portlet:renderURL portletMode="<%= PortletMode.VIEW.toString() %>" portletName="<%= StagingConfigurationPortletKeys.STAGING_CONFIGURATION %>" var="stagingConfigurationPortletURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="mvcRenderCommandName" value="staging" />
</liferay-portlet:renderURL>

<aui:script>
	function <portlet:namespace />openStagingConfigurationPortlet() {
		var configurationDialog = Liferay.Util.openWindow({
			dialog: {
				destroyOnHide: true,
				on: {
					visibleChange: function(event) {
						if (!event.newVal) {
							document.location.href =
								'<%= HtmlUtil.escapeJS(portletURL.toString()) %>';
						}
					},
				},
			},
			id: 'stagingConfiguration',
			title: '<liferay-ui:message key="staging-configuration" />',
			uri:
				'<%= HtmlUtil.escapeJS(stagingConfigurationPortletURL.toString()) %>',
		});
	}
</aui:script>