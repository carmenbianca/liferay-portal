<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
long exportImportConfigurationId = (Long)request.getAttribute(ExportImportWebKeys.EXPORT_IMPORT_CONFIGURATION_ID);

ExportImportConfiguration exportImportConfiguration = ExportImportConfigurationLocalServiceUtil.getExportImportConfiguration(exportImportConfigurationId);
%>

<liferay-ui:panel-container
	extended="<%= true %>"
	id="exportImportConfigurationPanelContainer"
	persistState="<%= false %>"
>
	<liferay-ui:panel
		collapsible="<%= false %>"
		extended="<%= true %>"
		title="template-type"
	>
		<liferay-ui:message key="<%= ExportImportConfigurationConstants.getTypeLabel(exportImportConfiguration.getType()) %>" />
	</liferay-ui:panel>

	<liferay-ui:panel
		collapsible="<%= false %>"
		extended="<%= true %>"
		title="created-by"
	>
		<liferay-ui:message key="<%= exportImportConfiguration.getUserName() %>" />
	</liferay-ui:panel>

	<liferay-ui:panel
		collapsible="<%= false %>"
		extended="<%= true %>"
		title="description"
	>
		<liferay-ui:message key="<%= HtmlUtil.escape(exportImportConfiguration.getDescription()) %>" />
	</liferay-ui:panel>
</liferay-ui:panel-container>