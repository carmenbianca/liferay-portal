<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String questionsRootElementId = renderResponse.getNamespace() + "-questions-root";
%>

<portlet:renderURL var="basePortletURL" />

<div id="<%= questionsRootElementId %>">

	<%
	Map<String, Object> data = HashMapBuilder.<String, Object>put(
		"isOmniAdmin", permissionChecker.isOmniadmin()
	).put(
		"siteKey", String.valueOf(themeDisplay.getScopeGroupId())
	).put(
		"userId", String.valueOf(themeDisplay.getUserId())
	).build();
	%>

	<react:component
		data="<%= data %>"
		module="js/index.es"
	/>
</div>