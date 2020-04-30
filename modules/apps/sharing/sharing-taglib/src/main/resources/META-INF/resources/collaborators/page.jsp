<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/collaborators/init.jsp" %>

<liferay-util:html-top
	outputKey="collaborators_css"
>
	<link href="<%= PortalUtil.getStaticResourceURL(request, application.getContextPath() + "/collaborators/css/main.css") %>" rel="stylesheet" type="text/css" />
</liferay-util:html-top>

<div class="collaborators" id="<portlet:namespace/>collaborators-root">
	<react:component
		data='<%= (Map<String, Object>)request.getAttribute("liferay-sharing:collaborators:data") %>'
		module="collaborators/js/index.es"
	/>
</div>