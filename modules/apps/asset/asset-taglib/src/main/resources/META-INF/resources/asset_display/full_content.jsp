<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/asset_display/init.jsp" %>

<%
AssetRenderer<?> assetRenderer = (AssetRenderer<?>)request.getAttribute(WebKeys.ASSET_RENDERER);

boolean showHeader = ParamUtil.getBoolean(request, "showHeader");
%>

<c:if test="<%= showHeader %>">
	<liferay-ui:header
		title="<%= assetRenderer.getTitle(locale) %>"
	/>
</c:if>

<%
String summary = StringUtil.shorten(assetRenderer.getSummary(renderRequest, renderResponse), Integer.MAX_VALUE);
%>

<%= HtmlUtil.escape(summary) %>