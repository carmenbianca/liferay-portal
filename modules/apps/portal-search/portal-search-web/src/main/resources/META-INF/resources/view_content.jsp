<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/asset" prefix="liferay-asset" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %><%@
page import="com.liferay.portal.kernel.util.HashMapBuilder" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.kernel.util.PortalUtil" %><%@
page import="com.liferay.portal.search.web.internal.result.display.builder.SearchResultContentDisplayBuilder" %><%@
page import="com.liferay.portal.search.web.internal.result.display.context.SearchResultContentDisplayContext" %>

<%@ page import="java.util.Map" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
SearchResultContentDisplayBuilder searchResultContentDisplayBuilder = new SearchResultContentDisplayBuilder();

searchResultContentDisplayBuilder.setAssetEntryId(ParamUtil.getLong(request, "assetEntryId"));
searchResultContentDisplayBuilder.setLocale(locale);
searchResultContentDisplayBuilder.setPermissionChecker(permissionChecker);
searchResultContentDisplayBuilder.setPortal(PortalUtil.getPortal());
searchResultContentDisplayBuilder.setRenderRequest(renderRequest);
searchResultContentDisplayBuilder.setRenderResponse(renderResponse);
searchResultContentDisplayBuilder.setType(ParamUtil.getString(request, "type"));

SearchResultContentDisplayContext searchResultContentDisplayContext = searchResultContentDisplayBuilder.build();
%>

<c:if test="<%= searchResultContentDisplayContext.isVisible() %>">
	<liferay-ui:header
		localizeTitle="<%= false %>"
		title="<%= searchResultContentDisplayContext.getHeaderTitle() %>"
	/>

	<c:if test="<%= searchResultContentDisplayContext.hasEditPermission() %>">
		<div class="asset-actions lfr-meta-actions">

			<%
			Map<String, Object> data = HashMapBuilder.<String, Object>put(
				"destroyOnHide", true
			).put(
				"id", HtmlUtil.escape(portletDisplay.getNamespace()) + "editAsset"
			).put(
				"title", LanguageUtil.format(request, "edit-x", HtmlUtil.escape(searchResultContentDisplayContext.getIconEditTarget()), false)
			).build();
			%>

			<liferay-ui:icon
				cssClass="visible-interaction"
				data="<%= data %>"
				icon="pencil"
				label="<%= false %>"
				markupView="lexicon"
				message='<%= LanguageUtil.format(request, "edit-x-x", new Object[] {"hide-accessible", HtmlUtil.escape(searchResultContentDisplayContext.getIconEditTarget())}, false) %>'
				method="get"
				url="<%= searchResultContentDisplayContext.getIconURLString() %>"
				useDialog="<%= true %>"
			/>
		</div>
	</c:if>

	<liferay-asset:asset-display
		assetEntry="<%= searchResultContentDisplayContext.getAssetEntry() %>"
		assetRenderer="<%= searchResultContentDisplayContext.getAssetRenderer() %>"
		assetRendererFactory="<%= searchResultContentDisplayContext.getAssetRendererFactory() %>"
	/>
</c:if>