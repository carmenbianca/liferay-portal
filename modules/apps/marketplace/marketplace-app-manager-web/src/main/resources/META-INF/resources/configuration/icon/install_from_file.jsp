<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<liferay-ui:icon
	message="upload"
	onClick='<%= renderResponse.getNamespace() + "uploadUrlLink();" %>'
	url="javascript:;"
/>

<aui:script>
	function <portlet:namespace />uploadUrlLink() {
		Liferay.Util.openWindow({
			dialog: {
				destroyOnHide: true,
			},
			title: '<liferay-ui:message key="upload" />',
			uri:
				'<liferay-portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/install_local_app.jsp" /></liferay-portlet:renderURL>',
		});
	}
</aui:script>