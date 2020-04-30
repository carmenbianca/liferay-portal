<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String cmd = GetterUtil.getString(request.getAttribute("liferay-export-import-changeset:export-import-entity-management-bar-button:cmd"));
String searchContainerId = GetterUtil.getString(request.getAttribute("liferay-export-import-changeset:export-import-entity-management-bar-button:searchContainerId"));
String searchContainerMappingId = GetterUtil.getString(request.getAttribute("liferay-export-import-changeset:export-import-entity-management-bar-button:searchContainerMappingId"));
%>