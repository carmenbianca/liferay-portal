<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
User selUser = (User)request.getAttribute("user.selUser");
%>

<liferay-ui:error-marker
	key="<%= WebKeys.ERROR_SECTION %>"
	value="openId"
/>

<aui:model-context bean="<%= selUser %>" model="<%= User.class %>" />

<liferay-ui:error exception="<%= DuplicateOpenIdException.class %>" message="a-user-with-that-openid-already-exists" />

<aui:input label="openid" name="openId" />