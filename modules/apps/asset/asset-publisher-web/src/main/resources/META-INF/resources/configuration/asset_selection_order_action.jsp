<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

int assetEntryOrder = searchContainer.getStart() + row.getPos();

boolean last = assetEntryOrder == (searchContainer.getTotal() - 1);
%>

<c:choose>
	<c:when test="<%= (assetEntryOrder == 0) && last %>">
	</c:when>
	<c:when test="<%= (assetEntryOrder > 0) && !last %>">

		<%
		String taglibUpURL = "javascript:" + renderResponse.getNamespace() + "moveSelectionUp('" + assetEntryOrder + "')";
		%>

		<liferay-ui:icon
			icon="angle-up"
			markupView="lexicon"
			message="up"
			url="<%= taglibUpURL %>"
		/>

		<%
		String taglibDownURL = "javascript:" + renderResponse.getNamespace() + "moveSelectionDown('" + assetEntryOrder + "')";
		%>

		<liferay-ui:icon
			icon="angle-down"
			markupView="lexicon"
			message="down"
			url="<%= taglibDownURL %>"
		/>
	</c:when>
	<c:when test="<%= assetEntryOrder == 0 %>">

		<%
		String taglibDownURL = "javascript:" + renderResponse.getNamespace() + "moveSelectionDown('" + assetEntryOrder + "')";
		%>

		<liferay-ui:icon
			icon="angle-down"
			markupView="lexicon"
			message="down"
			url="<%= taglibDownURL %>"
		/>
	</c:when>
	<c:when test="<%= last %>">

		<%
		String taglibUpURL = "javascript:" + renderResponse.getNamespace() + "moveSelectionUp('" + assetEntryOrder + "')";
		%>

		<liferay-ui:icon
			icon="angle-up"
			markupView="lexicon"
			message="up"
			url="<%= taglibUpURL %>"
		/>
	</c:when>
</c:choose>