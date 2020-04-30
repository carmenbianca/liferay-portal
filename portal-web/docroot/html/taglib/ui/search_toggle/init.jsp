<%--
/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/taglib/init.jsp" %>

<%
boolean autoFocus = GetterUtil.getBoolean((String)request.getAttribute("liferay-ui:search-toggle:autoFocus"));
String buttonLabel = (String)request.getAttribute("liferay-ui:search-toggle:buttonLabel");
DisplayTerms displayTerms = (DisplayTerms)request.getAttribute("liferay-ui:search-toggle:displayTerms");
String id = (String)request.getAttribute("liferay-ui:search-toggle:id");
%>