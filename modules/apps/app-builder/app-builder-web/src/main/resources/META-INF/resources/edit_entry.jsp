<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
AppBuilderApp appBuilderApp = (AppBuilderApp)request.getAttribute(AppBuilderWebKeys.APP);
%>

<div class="app-builder-root">
	<div class="container edit-entry">
		<div id="<%= renderResponse.getNamespace() %>-control-menu"></div>

		<div class="justify-content-center row">
			<div class="col-lg-12">
				<div class="card card-root mb-0 mt-4 shadowless-card">
					<div class="card-body pt-0">
						<aui:form>
							<liferay-data-engine:data-layout-renderer
								containerId='<%= renderResponse.getNamespace() + "container" %>'
								dataLayoutId="<%= appBuilderApp.getDdmStructureLayoutId() %>"
								dataRecordId='<%= ParamUtil.getLong(request, "dataRecordId") %>'
								namespace="<%= renderResponse.getNamespace() %>"
							/>

							<div id="<portlet:namespace />-edit-entry-app">

								<%
								Map<String, Object> data = HashMapBuilder.<String, Object>put(
									"appDeploymentType", request.getAttribute(AppBuilderWebKeys.APP_DEPLOYMENT_TYPE)
								).put(
									"appId", appBuilderApp.getAppBuilderAppId()
								).put(
									"basePortletURL", String.valueOf(renderResponse.createRenderURL())
								).put(
									"controlMenuElementId", renderResponse.getNamespace() + "-control-menu"
								).put(
									"dataDefinitionId", appBuilderApp.getDdmStructureId()
								).put(
									"dataLayoutId", appBuilderApp.getDdmStructureLayoutId()
								).put(
									"dataListViewId", appBuilderApp.getDeDataListViewId()
								).put(
									"dataRecordId", ParamUtil.getLong(request, "dataRecordId")
								).put(
									"editEntryContainerElementId", renderResponse.getNamespace() + "container"
								).put(
									"redirect", ParamUtil.getString(request, "redirect")
								).put(
									"showFormView", request.getAttribute(AppBuilderWebKeys.SHOW_FORM_VIEW)
								).put(
									"showTableView", request.getAttribute(AppBuilderWebKeys.SHOW_TABLE_VIEW)
								).build();
								%>

								<react:component
									data="<%= data %>"
									module="js/pages/entry/EditEntryApp.es"
								/>
							</div>
						</aui:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>