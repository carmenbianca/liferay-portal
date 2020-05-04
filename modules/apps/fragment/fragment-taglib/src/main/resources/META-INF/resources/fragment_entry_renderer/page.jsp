<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/fragment_entry_renderer/init.jsp" %>

<%
String randomNamespace = PortalUtil.generateRandomKey(request, "taglib_fragment_entry_renderer_page") + StringPool.UNDERLINE;

FragmentEntry fragmentEntry = (FragmentEntry)request.getAttribute("liferay-fragment:fragment-entry-renderer:fragmentEntry");
%>

<liferay-util:html-top
	outputKey="<%= randomNamespace %>"
>
	<style type="text/css">
		<%= fragmentEntry.getCss() %>
	</style>
</liferay-util:html-top>

<div id="<%= randomNamespace %>">
	<%= fragmentEntry.getHtml() %>
</div>

<aui:script>
	(function() {
		var fragment = document.getElementById('<%= randomNamespace %>');

		<%= fragmentEntry.getJs() %>;
	})();
</aui:script>