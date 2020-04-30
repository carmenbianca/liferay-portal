<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<liferay-ui:tabs
	names="Alerts,Badges,Buttons,Cards,Dropdowns,Form Elements,Icons,Labels,Links,Management Toolbars,Navigation Bars,Progress Bars,Stickers,Tables"
	refresh="<%= false %>"
>

	<%
	String[] sections = {"alerts", "badges", "buttons", "cards", "dropdowns", "form_elements", "icons", "labels", "links", "management_toolbars", "navigation_bars", "progress_bars", "stickers", "tables"};

	for (int i = 0; i < sections.length; i++) {
		String partial = "/partials/" + sections[i] + ".jsp";
	%>

		<liferay-ui:section>
			<div class="container-fluid-1280">
				<liferay-util:include page="<%= partial %>" servletContext="<%= application %>" />
			</div>
		</liferay-ui:section>

	<%
	}
	%>

</liferay-ui:tabs>