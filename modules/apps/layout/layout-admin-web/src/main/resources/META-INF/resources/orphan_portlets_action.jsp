<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Portlet portlet = (Portlet)row.getObject();
%>

<portlet:actionURL name="/layout/delete_orphan_portlets" var="deleteOrphanPortletsURL">
	<portlet:param name="redirect" value="<%= currentURL %>" />
	<portlet:param name="portletId" value="<%= portlet.getPortletId() %>" />
	<portlet:param name="selPlid" value="<%= String.valueOf(layoutsAdminDisplayContext.getSelPlid()) %>" />
</portlet:actionURL>

<liferay-ui:icon
	icon="times-circle"
	linkCssClass="icon-monospaced text-default"
	markupView="lexicon"
	url="<%= deleteOrphanPortletsURL %>"
/>