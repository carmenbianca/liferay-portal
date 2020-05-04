<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
Layout selLayout = layoutsAdminDisplayContext.getSelLayout();

UnicodeProperties layoutTypeSettings = null;

if (selLayout != null) {
	layoutTypeSettings = selLayout.getTypeSettingsProperties();
}
%>

<liferay-ui:error-marker
	key="<%= WebKeys.ERROR_SECTION %>"
	value="javascript"
/>

<aui:model-context bean="<%= selLayout %>" model="<%= Layout.class %>" />

<aui:input cssClass="propagatable-field" disabled="<%= selLayout.isLayoutPrototypeLinkActive() %>" label="paste-javascript-code-that-is-executed-at-the-bottom-of-the-page" name="TypeSettingsProperties--javascript--" placeholder="javascript" type="textarea" value='<%= layoutTypeSettings.getProperty("javascript") %>' wrap="soft" />