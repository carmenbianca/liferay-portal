<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/page_template/init.jsp" %>

<%
EditDisplayPageMenuDisplayContext editDisplayPageMenuDisplayContext = new EditDisplayPageMenuDisplayContext(request);
%>

<clay:dropdown-menu
	dropdownItems="<%= editDisplayPageMenuDisplayContext.getDropdownItems() %>"
	icon="pencil"
	triggerCssClasses="icon-monospaced"
/>