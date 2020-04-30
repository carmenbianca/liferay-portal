<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
ExportImportConfiguration exportImportConfiguration = (ExportImportConfiguration)request.getAttribute("liferay-staging:configuration-header:exportImportConfiguration");
String label = GetterUtil.getString(request.getAttribute("liferay-staging:configuration-header:label"));
%>