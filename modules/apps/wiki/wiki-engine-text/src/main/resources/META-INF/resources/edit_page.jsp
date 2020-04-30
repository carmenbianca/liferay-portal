<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
WikiPage wikiPage = BaseWikiEngine.getWikiPage(request);
%>

<liferay-ui:input-field
	bean="<%= wikiPage %>"
	field="content"
	model="<%= WikiPage.class %>"
/>