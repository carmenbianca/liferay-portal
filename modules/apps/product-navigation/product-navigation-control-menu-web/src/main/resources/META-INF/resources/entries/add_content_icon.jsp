<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String portletNamespace = PortalUtil.getPortletNamespace(ProductNavigationControlMenuPortletKeys.PRODUCT_NAVIGATION_CONTROL_MENU);

PortletURL addPanelURL = PortletURLFactoryUtil.create(request, ProductNavigationControlMenuPortletKeys.PRODUCT_NAVIGATION_CONTROL_MENU, PortletRequest.RENDER_PHASE);

addPanelURL.setParameter("mvcPath", "/add_panel.jsp");
addPanelURL.setParameter("stateMaximized", String.valueOf(themeDisplay.isStateMaximized()));
addPanelURL.setWindowState(LiferayWindowState.EXCLUSIVE);
%>

<li class="control-menu-nav-item">
	<a aria-label="<%= LanguageUtil.get(request, "add") %>" class="control-menu-icon lfr-portal-tooltip product-menu-toggle sidenav-toggler" data-content="body" data-open-class="open-admin-panel" data-qa-id="add" data-target="#<%= portletNamespace %>addPanelId" data-title="<%= LanguageUtil.get(request, "add") %>" data-toggle="liferay-sidenav" data-type="fixed-push" data-type-mobile="fixed" data-url="<%= addPanelURL.toString() %>" href="javascript:;" id="<%= portletNamespace %>addToggleId">
		<aui:icon cssClass="icon-monospaced" image="plus" markupView="lexicon" />
	</a>
</li>

<%
AssetRenderer<?> assetRenderer = null;
Map<String, Object> data = new HashMap<String, Object>();

String portletResourceNamespace = PortalUtil.getPortletNamespace(ParamUtil.getString(request, "portletResource"));

String className = ParamUtil.getString(request, portletResourceNamespace + "className");
long classPK = ParamUtil.getLong(request, portletResourceNamespace + "classPK");

String portletId = PortletProviderUtil.getPortletId(className, PortletProvider.Action.ADD);

if (Validator.isNotNull(className) && (classPK > 0)) {
	AssetRendererFactory<?> assetRendererFactory = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(className);

	assetRenderer = assetRendererFactory.getAssetRenderer(classPK);

	data.put("class-name", className);
	data.put("class-pk", classPK);
	data.put("instanceable", true);
	data.put("portlet-id", portletId);
}
%>

<span <%= AUIUtil.buildData(data) %> class="hide portlet-item"></span>

<c:if test="<%= (assetRenderer != null) && PortletPermissionUtil.contains(permissionChecker, layout, portletId, ActionKeys.ADD_TO_PAGE) %>">
	<aui:script use="aui-base">
		Liferay.fire('AddContent:addPortlet', {
			node: A.one('.portlet-item'),
		});

		Liferay.once('updatedLayout', function() {
			Liferay.Util.navigate(
				'<%= PortalUtil.getLayoutFullURL(layout, themeDisplay) %>'
			);
		});
	</aui:script>
</c:if>