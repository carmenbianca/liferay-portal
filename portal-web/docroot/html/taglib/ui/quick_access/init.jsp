<%--
/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/taglib/init.jsp" %>

<%@ page import="com.liferay.portal.kernel.servlet.taglib.ui.QuickAccessEntry" %>

<%
String contentId = (String)request.getAttribute("liferay-ui:quick-access:contentId");
List<QuickAccessEntry> quickAccessEntries = (List<QuickAccessEntry>)request.getAttribute("liferay-ui:quick-access:quickAccessEntries");
%>