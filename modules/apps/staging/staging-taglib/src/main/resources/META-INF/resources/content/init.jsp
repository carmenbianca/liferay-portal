<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String cmd = GetterUtil.getString(request.getAttribute("liferay-staging:content:cmd"));
boolean disableInputs = GetterUtil.getBoolean(request.getAttribute("liferay-staging:content:disableInputs"));
long exportImportConfigurationId = GetterUtil.getLong(request.getAttribute("liferay-staging:content:exportImportConfigurationId"));
boolean showAllPortlets = GetterUtil.getBoolean(request.getAttribute("liferay-staging:content:showAllPortlets"));
String type = GetterUtil.getString(request.getAttribute("liferay-staging:content:type"));

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

List<Portlet> dataSiteLevelPortlets = ExportImportHelperUtil.getDataSiteLevelPortlets(company.getCompanyId(), false);

DateRange dateRange = null;
Map<String, Serializable> settingsMap = Collections.emptyMap();
Map<String, String[]> parameterMap = Collections.emptyMap();

ExportImportConfiguration exportImportConfiguration = ExportImportConfigurationLocalServiceUtil.fetchExportImportConfiguration(exportImportConfigurationId);

if (exportImportConfiguration != null) {
	dateRange = ExportImportDateUtil.getDateRange(exportImportConfiguration);

	settingsMap = exportImportConfiguration.getSettingsMap();

	parameterMap = (Map<String, String[]>)settingsMap.get("parameterMap");
}
else {
	dateRange = ExportImportDateUtil.getDateRange(renderRequest, exportGroupId, privateLayout, 0, null, defaultRange);
}

Date startDate = dateRange.getStartDate();
Date endDate = dateRange.getEndDate();
%>