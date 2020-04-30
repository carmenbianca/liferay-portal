<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String customUserAttributes = GetterUtil.getString(portletPreferences.getValue("customUserAttributes", StringPool.BLANK));
%>

<aui:input helpMessage='<%= LanguageUtil.get(resourceBundle, "custom-user-attributes-help") %>' label='<%= LanguageUtil.get(resourceBundle, "displayed-assets-must-match-these-custom-user-profile-attributes") %>' name="preferences--customUserAttributes--" value="<%= customUserAttributes %>" />