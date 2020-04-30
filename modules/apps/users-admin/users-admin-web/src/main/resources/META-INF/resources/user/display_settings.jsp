<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
User selUser = (User)request.getAttribute(UsersAdminWebKeys.SELECTED_USER);
%>

<aui:model-context bean="<%= selUser %>" model="<%= User.class %>" />

<aui:input label="time-zone" name="timeZoneId" type="timeZone" />

<aui:input name="greeting" />