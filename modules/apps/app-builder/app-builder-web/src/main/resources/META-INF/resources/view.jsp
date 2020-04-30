<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String appBuilderRootElementId = renderResponse.getNamespace() + "-app-builder-root";
%>

<liferay-util:html-top>
	<link href="<%= PortalUtil.getStaticResourceURL(request, PortalUtil.getPathModule() + "/data-engine-taglib/data_layout_builder/css/main.css") %>" rel="stylesheet" />
</liferay-util:html-top>

<portlet:renderURL var="basePortletURL" />

<div id="<%= appBuilderRootElementId %>">

	<%
	Map<String, Object> data = HashMapBuilder.<String, Object>put(
		"basePortletURL", basePortletURL
	).put(
		"pathFriendlyURLPublic", PortalUtil.getPathFriendlyURLPublic()
	).build();
	%>

	<react:component
		data="<%= data %>"
		module="js/index.es"
	/>
</div>