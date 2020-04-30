<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<liferay-ui:icon
	message="install-from-url"
	onClick='<%= renderResponse.getNamespace() + "openInstallFromURLView()" %>'
	url="javascript:;"
/>

<aui:script>
	function <portlet:namespace />openInstallFromURLView() {
		Liferay.Util.openWindow({
			dialog: {
				destroyOnHide: true,
			},
			id: '<portlet:namespace />openInstallFromURLView',
			title: '<liferay-ui:message key="install-from-url" />',
			uri:
				'<liferay-portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/install_remote_app.jsp" /><portlet:param name="redirect" value="<%= String.valueOf(renderResponse.createRenderURL()) %>" /></liferay-portlet:renderURL>',
		});
	}
</aui:script>