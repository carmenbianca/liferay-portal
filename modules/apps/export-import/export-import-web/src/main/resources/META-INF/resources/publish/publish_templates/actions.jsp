<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
long groupId = ParamUtil.getLong(request, "groupId");
long layoutSetBranchId = ParamUtil.getLong(request, "layoutSetBranchId");
String layoutSetBranchName = ParamUtil.getString(request, "layoutSetBranchName");
boolean localPublishing = ParamUtil.getBoolean(request, "localPublishing");
boolean privateLayout = ParamUtil.getBoolean(request, "privateLayout");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ExportImportConfiguration exportImportConfiguration = (ExportImportConfiguration)row.getObject();
%>

<portlet:renderURL var="publishByExportImportConfigurationURL">
	<portlet:param name="mvcRenderCommandName" value="publishLayouts" />
	<portlet:param name="<%= Constants.CMD %>" value="<%= localPublishing ? Constants.PUBLISH_TO_LIVE : Constants.PUBLISH_TO_REMOTE %>" />
	<portlet:param name="exportImportConfigurationId" value="<%= String.valueOf(exportImportConfiguration.getExportImportConfigurationId()) %>" />
	<portlet:param name="groupId" value="<%= String.valueOf(groupId) %>" />
	<portlet:param name="layoutSetBranchId" value="<%= String.valueOf(layoutSetBranchId) %>" />
	<portlet:param name="layoutSetBranchName" value="<%= layoutSetBranchName %>" />
	<portlet:param name="privateLayout" value="<%= String.valueOf(privateLayout) %>" />
	<portlet:param name="publishConfigurationButtons" value="template" />
</portlet:renderURL>

<liferay-ui:icon-menu
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	showWhenSingleIcon="<%= true %>"
>
	<liferay-ui:icon
		message='<%= localPublishing ? "publish-to-live" : "publish-to-remote-live" %>'
		url="<%= publishByExportImportConfigurationURL %>"
	/>
</liferay-ui:icon-menu>