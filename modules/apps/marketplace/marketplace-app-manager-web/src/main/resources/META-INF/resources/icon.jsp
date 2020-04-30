<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String iconURL = ParamUtil.getString(request, "iconURL");
%>

<div class="search-container-icon sticker sticker-secondary">
	<c:choose>
		<c:when test='<%= iconURL.contains(".svg#") %>'>
			<svg class="lexicon-icon">
				<use xlink:href="<%= iconURL %>" />
			</svg>
		</c:when>
		<c:when test="<%= Validator.isUrl(iconURL) %>">
			<img alt="thumbnail" class="img-fluid" src="<%= iconURL %>" />
		</c:when>
	</c:choose>
</div>