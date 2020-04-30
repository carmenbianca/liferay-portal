<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
boolean disableInputs = GetterUtil.getBoolean(request.getAttribute("liferay-staging:remote-options:disableInputs"));
long exportImportConfigurationId = GetterUtil.getLong(request.getAttribute("liferay-staging:remote-options:exportImportConfigurationId"));
privateLayout = GetterUtil.getBoolean(request.getAttribute("liferay-staging:remote-options:privateLayout"), privateLayout);

Map<String, Serializable> settingsMap = Collections.emptyMap();

ExportImportConfiguration exportImportConfiguration = ExportImportConfigurationLocalServiceUtil.fetchExportImportConfiguration(exportImportConfigurationId);

if (exportImportConfiguration != null) {
	settingsMap = exportImportConfiguration.getSettingsMap();
}

UnicodeProperties liveGroupTypeSettings = liveGroup.getTypeSettingsProperties();
%>