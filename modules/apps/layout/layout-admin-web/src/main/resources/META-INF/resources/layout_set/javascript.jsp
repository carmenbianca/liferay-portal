<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
LayoutSet selLayoutSet = layoutsAdminDisplayContext.getSelLayoutSet();

UnicodeProperties layoutSetTypeSettings = selLayoutSet.getSettingsProperties();
%>

<liferay-ui:error-marker
	key="<%= WebKeys.ERROR_SECTION %>"
	value="javascript"
/>

<aui:input label="paste-javascript-code-that-is-executed-at-the-bottom-of-every-page" name="TypeSettingsProperties--javascript--" placeholder="javascript" type="textarea" value='<%= layoutSetTypeSettings.getProperty("javascript") %>' wrap="soft" />