<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/panel_category_body/init.jsp" %>

<c:if test="<%= !panelApps.isEmpty() %>">
	<ul aria-labelledby="<%= id %>" class="nav nav-equal-height nav-stacked" role="menu">

		<%
		for (PanelApp panelApp : panelApps) {
		%>

			<liferay-application-list:panel-app
				panelApp="<%= panelApp %>"
			/>

		<%
		}
		%>

	</ul>
</c:if>

<liferay-application-list:panel
	panelCategory="<%= panelCategory %>"
/>