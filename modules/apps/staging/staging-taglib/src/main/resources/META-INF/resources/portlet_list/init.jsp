<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
boolean disableInputs = GetterUtil.getBoolean(request.getAttribute("liferay-staging:portlet-list:disableInputs"));
long exportImportConfigurationId = GetterUtil.getLong(request.getAttribute("liferay-staging:portlet-list:exportImportConfigurationId"));
List<Portlet> portlets = (List<Portlet>)GetterUtil.getObject(request.getAttribute("liferay-staging:portlet-list:portlets"), Collections.emptyList());
boolean showAllPortlets = GetterUtil.getBoolean(request.getAttribute("liferay-staging:portlet-list:showAllPortlets"));
String type = GetterUtil.getString(request.getAttribute("liferay-staging:portlet-list:type"));

Set<String> displayedControls = new HashSet<String>();
Set<String> portletDataHandlerClassNames = new HashSet<String>();

String defaultRange = null;
long exportGroupId = groupId;

if (type.equals(Constants.EXPORT)) {
	defaultRange = ExportImportDateUtil.RANGE_ALL;

	if (liveGroupId > 0) {
		exportGroupId = liveGroupId;
	}
}
else {
	defaultRange = ExportImportDateUtil.RANGE_FROM_LAST_PUBLISH_DATE;

	if (stagingGroupId > 0) {
		exportGroupId = stagingGroupId;
	}
}

Map<String, Serializable> settingsMap = Collections.emptyMap();
Map<String, String[]> parameterMap = Collections.emptyMap();

ExportImportConfiguration exportImportConfiguration = ExportImportConfigurationLocalServiceUtil.fetchExportImportConfiguration(exportImportConfigurationId);

if (exportImportConfiguration != null) {
	settingsMap = exportImportConfiguration.getSettingsMap();

	parameterMap = (Map<String, String[]>)settingsMap.get("parameterMap");
}

String range = ParamUtil.getString(portletRequest, ExportImportDateUtil.RANGE, null);

boolean useRequestValues = false;

if ((range != null) || (exportImportConfiguration == null)) {
	useRequestValues = true;
}
%>