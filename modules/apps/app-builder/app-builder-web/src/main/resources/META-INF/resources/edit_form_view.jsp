<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String componentId = renderResponse.getNamespace() + "dataLayoutBuilder";
String customObjectSidebarElementId = renderResponse.getNamespace() + "-app-builder-custom-object-sidebar";
String dataLayoutBuilderElementId = renderResponse.getNamespace() + "-app-builder-data-layout-builder";
String editFormViewRootElementId = renderResponse.getNamespace() + "-app-builder-edit-form-view";

long dataDefinitionId = ParamUtil.getLong(request, "dataDefinitionId");
long dataLayoutId = ParamUtil.getLong(request, "dataLayoutId");
boolean newCustomObject = ParamUtil.getBoolean(request, "newCustomObject");
%>

<div class="app-builder-root">
	<aui:form>
		<aui:input name="dataDefinition" type="hidden" />
		<aui:input name="dataLayout" type="hidden" />

		<portlet:renderURL var="basePortletURL" />

		<div class="app-builder-form-view-app" id="<%= editFormViewRootElementId %>">

			<%
			Map<String, Object> data = HashMapBuilder.<String, Object>put(
				"basePortletURL", basePortletURL.toString()
			).put(
				"customObjectSidebarElementId", customObjectSidebarElementId
			).put(
				"dataDefinitionId", dataDefinitionId
			).put(
				"dataLayoutBuilderElementId", dataLayoutBuilderElementId
			).put(
				"dataLayoutBuilderId", componentId
			).put(
				"dataLayoutId", dataLayoutId
			).put(
				"newCustomObject", newCustomObject
			).build();
			%>

			<react:component
				data="<%= data %>"
				module="js/pages/form-view/EditFormViewApp.es"
			/>
		</div>

		<div class="app-builder-form-view-body">
			<div class="app-builder-custom-object-sidebar" id="<%= customObjectSidebarElementId %>"></div>

			<div class="data-layout-builder-wrapper" id="<%= dataLayoutBuilderElementId %>">
				<liferay-data-engine:data-layout-builder
					componentId="<%= componentId %>"
					contentType="app-builder"
					dataDefinitionId="<%= dataDefinitionId %>"
					dataLayoutId="<%= dataLayoutId %>"
					namespace="<%= renderResponse.getNamespace() %>"
					scopes='<%= SetUtil.fromCollection(Arrays.asList("app-builder")) %>'
				/>
			</div>
		</div>
	</aui:form>
</div>