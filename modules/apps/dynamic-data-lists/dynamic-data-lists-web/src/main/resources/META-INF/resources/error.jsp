<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<liferay-ui:header
	showBackURL="<%= false %>"
	title="error"
/>

<liferay-ui:error exception="<%= NoSuchRecordException.class %>" message="the-record-could-not-be-found" />
<liferay-ui:error exception="<%= NoSuchRecordSetException.class %>" message="the-recordSet-could-not-be-found" />
<liferay-ui:error exception="<%= PortletPreferencesException.MustBeStrict.class %>" message="portlet-preferences-are-not-configured-properly" />

<liferay-ui:error-principal />