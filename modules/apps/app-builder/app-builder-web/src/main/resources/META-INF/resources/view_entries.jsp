<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<div id="<portlet:namespace />-app-builder-root">

	<%
	AppBuilderApp appBuilderApp = (AppBuilderApp)request.getAttribute(AppBuilderWebKeys.APP);

	Map<String, Object> data = HashMapBuilder.<String, Object>put(
		"appDeploymentType", request.getAttribute(AppBuilderWebKeys.APP_DEPLOYMENT_TYPE)
	).put(
		"appId", appBuilderApp.getAppBuilderAppId()
	).put(
		"basePortletURL", String.valueOf(renderResponse.createRenderURL())
	).put(
		"dataDefinitionId", appBuilderApp.getDdmStructureId()
	).put(
		"dataLayoutId", appBuilderApp.getDdmStructureLayoutId()
	).put(
		"dataListViewId", appBuilderApp.getDeDataListViewId()
	).put(
		"showFormView", request.getAttribute(AppBuilderWebKeys.SHOW_FORM_VIEW)
	).put(
		"showTableView", request.getAttribute(AppBuilderWebKeys.SHOW_TABLE_VIEW)
	).build();
	%>

	<react:component
		data="<%= data %>"
		module="js/pages/entry/ViewEntriesApp.es"
	/>
</div>