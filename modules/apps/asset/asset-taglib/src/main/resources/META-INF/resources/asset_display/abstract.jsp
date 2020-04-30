<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/asset_display/init.jsp" %>

<%
AssetRenderer<?> assetRenderer = (AssetRenderer<?>)request.getAttribute(WebKeys.ASSET_RENDERER);
int abstractLength = GetterUtil.getInteger(request.getAttribute(WebKeys.ASSET_ENTRY_ABSTRACT_LENGTH));
%>

<div class="asset-summary">

	<%
	String imagePreviewURL = assetRenderer.getURLImagePreview(renderRequest);
	%>

	<c:if test="<%= Validator.isNotNull(imagePreviewURL) %>">
		<div class="aspect-ratio aspect-ratio-8-to-3 aspect-ratio-bg-cover cover-image mb-4" style="background-image: url(<%= imagePreviewURL %>);"></div>
	</c:if>

	<%
	String summary = StringUtil.shorten(assetRenderer.getSummary(renderRequest, renderResponse), abstractLength);
	%>

	<%= HtmlUtil.replaceNewLine(HtmlUtil.escape(summary)) %>
</div>