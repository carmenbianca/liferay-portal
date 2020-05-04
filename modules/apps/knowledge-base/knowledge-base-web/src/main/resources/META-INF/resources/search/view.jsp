<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/search/init.jsp" %>

<liferay-portlet:renderURL varImpl="searchURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
	<portlet:param name="mvcPath" value="/search/search.jsp" />
</liferay-portlet:renderURL>

<div class="form-search">
	<aui:form action="<%= searchURL %>" method="get" name="searchFm">
		<liferay-portlet:renderURLParams varImpl="searchURL" />

		<liferay-ui:input-search
			name="keywords"
			placeholder='<%= LanguageUtil.get(request, "keywords") %>'
		/>
	</aui:form>
</div>