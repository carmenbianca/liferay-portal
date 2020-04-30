<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/shared_assets/init.jsp" %>

<liferay-ui:error-header />

<liferay-ui:error exception="<%= NoSuchEntryException.class %>" message="the-item-is-no-longer-shared-with-you" />

<liferay-ui:error-principal />