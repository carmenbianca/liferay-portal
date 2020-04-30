<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/process_list_menu/init.jsp" %>

<liferay-ui:icon-menu
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>"
>
	<c:if test="<%= relaunchMenu %>">
		<%@ include file="/process_list_menu/items/relaunch.jspf" %>
	</c:if>

	<c:if test="<%= deleteMenu %>">
		<%@ include file="/process_list_menu/items/delete.jspf" %>
	</c:if>

	<c:if test="<%= summaryMenu %>">
		<%@ include file="/process_list_menu/items/summary.jspf" %>
	</c:if>
</liferay-ui:icon-menu>