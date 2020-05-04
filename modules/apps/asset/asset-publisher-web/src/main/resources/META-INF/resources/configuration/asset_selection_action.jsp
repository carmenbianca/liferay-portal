<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

int assetEntryOrder = searchContainer.getStart() + row.getPos();
%>

<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="deleteURL">
	<portlet:param name="<%= Constants.CMD %>" value="remove-selection" />
	<portlet:param name="redirect" value="<%= currentURL %>" />
	<portlet:param name="assetEntryOrder" value="<%= String.valueOf(assetEntryOrder) %>" />
</liferay-portlet:actionURL>

<liferay-ui:icon
	icon="times-circle"
	markupView="lexicon"
	url="<%= deleteURL %>"
/>