<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/unsubscribe/init.jsp" %>

<liferay-ui:header
	title="error"
/>

<liferay-ui:error exception="<%= NoSuchTicketException.class %>" message="the-link-is-no-longer-valid" />

<liferay-ui:error-principal />