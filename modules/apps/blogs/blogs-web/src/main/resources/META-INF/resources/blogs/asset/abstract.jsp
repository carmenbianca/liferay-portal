<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
BlogsEntry entry = (BlogsEntry)request.getAttribute(WebKeys.BLOGS_ENTRY);
%>

<div class="asset-summary">

	<%
	String coverImageURL = entry.getCoverImageURL(themeDisplay);
	%>

	<c:if test="<%= Validator.isNotNull(coverImageURL) %>">
		<div class="aspect-ratio aspect-ratio-8-to-3 aspect-ratio-bg-cover cover-image mb-4" style="background-image: url(<%= coverImageURL %>);"></div>
	</c:if>

	<%
	AssetRenderer<?> assetRenderer = (AssetRenderer<?>)request.getAttribute(WebKeys.ASSET_RENDERER);
	%>

	<%= HtmlUtil.stripHtml(assetRenderer.getSummary(renderRequest, renderResponse)) %>
</div>