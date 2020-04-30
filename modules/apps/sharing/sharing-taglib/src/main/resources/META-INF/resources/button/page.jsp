<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/button/init.jsp" %>

<%
String randomNamespace = PortalUtil.generateRandomKey(request, "taglib_sharing_button_page") + StringPool.UNDERLINE;

String buttonComponentId = randomNamespace + "shareButton";
%>

<clay:button
	elementClasses="btn-secondary"
	id="<%= buttonComponentId %>"
	label='<%= LanguageUtil.get(request, "share") %>'
	size="sm"
	style="secondary"
/>

<aui:script>
	var button = document.getElementById('<%= buttonComponentId %>');

	button.addEventListener('click', function() {
		<%= request.getAttribute("liferay-sharing:button:onClick") %>;
	});
</aui:script>