<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<liferay-util:dynamic-include key="com.liferay.users.admin.web#/user/memberships.jsp#pre" />

<div class="sheet-section">
	<liferay-util:include page="/user/sites.jsp" servletContext="<%= application %>" />
</div>

<div class="sheet-section">
	<liferay-util:include page="/user/user_groups.jsp" servletContext="<%= application %>" />
</div>

<liferay-util:dynamic-include key="com.liferay.users.admin.web#/user/memberships.jsp#post" />