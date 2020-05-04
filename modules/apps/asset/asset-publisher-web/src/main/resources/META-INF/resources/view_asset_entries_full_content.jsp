<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
long previewClassNameId = ParamUtil.getLong(request, "previewClassNameId");
long previewClassPK = ParamUtil.getLong(request, "previewClassPK");
int previewType = ParamUtil.getInteger(request, "previewType");

AssetEntryResult assetEntryResult = (AssetEntryResult)request.getAttribute("view.jsp-assetEntryResult");

for (AssetEntry assetEntry : assetEntryResult.getAssetEntries()) {
	AssetRendererFactory<?> assetRendererFactory = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassNameId(assetEntry.getClassNameId());

	if (assetRendererFactory == null) {
		continue;
	}

	AssetRenderer<?> assetRenderer = null;

	try {
		if ((previewClassNameId == assetEntry.getClassNameId()) && (previewClassPK == assetEntry.getClassPK())) {
			assetRenderer = assetRendererFactory.getAssetRenderer(assetEntry.getClassPK(), previewType);
		}
		else {
			assetRenderer = assetRendererFactory.getAssetRenderer(assetEntry.getClassPK());
		}
	}
	catch (Exception e) {
		if (_log.isWarnEnabled()) {
			_log.warn(e, e);
		}
	}

	if ((assetRenderer == null) || (!assetRenderer.isDisplayable() && (previewClassPK <= 0))) {
		continue;
	}

	request.setAttribute("view.jsp-assetEntry", assetEntry);
	request.setAttribute("view.jsp-assetRenderer", assetRenderer);
	request.setAttribute("view.jsp-assetRendererFactory", assetRendererFactory);
%>

	<liferay-util:include page="/view_asset_entry_full_content.jsp" servletContext="<%= application %>" />

<%
}
%>

<%!
private static Log _log = LogFactoryUtil.getLog("com_liferay_asset_publisher_web.view_asset_entries_full_content_jsp");
%>