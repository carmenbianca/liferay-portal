<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/taglib/init.jsp" %>

<%@ page import="com.liferay.dynamic.data.mapping.kernel.DDMTemplate" %><%@
page import="com.liferay.portal.kernel.servlet.taglib.ui.LanguageEntry" %>

<%
String formName = (String)request.getAttribute("liferay-ui:language:formName");
String formAction = (String)request.getAttribute("liferay-ui:language:formAction");
String displayStyle = GetterUtil.getString((String)request.getAttribute("liferay-ui:language:displayStyle"));
long displayStyleGroupId = GetterUtil.getLong(request.getAttribute("liferay-ui:language:displayStyleGroupId"), scopeGroupId);
List<LanguageEntry> languageEntries = (List<LanguageEntry>)request.getAttribute("liferay-ui:language:languageEntries");
String languageId = GetterUtil.getString((String)request.getAttribute("liferay-ui:language:languageId"), themeDisplay.getLanguageId());
String name = (String)request.getAttribute("liferay-ui:language:name");
%>