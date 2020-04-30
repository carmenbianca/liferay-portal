<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/bookmarks/init.jsp" %>

<liferay-ui:error-header />

<liferay-ui:error exception="<%= NoSuchEntryException.class %>" message="the-entry-could-not-be-found" />
<liferay-ui:error exception="<%= NoSuchFolderException.class %>" message="the-folder-could-not-be-found" />

<liferay-ui:error-principal />