<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<c:if test="<%= themeDisplay.isShowSignOutIcon() %>">
	<aui:a cssClass="list-group-heading" href="<%= themeDisplay.getURLSignOut() %>" label="sign-out" />
</c:if>