<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/taglib/ui/search_container/init.jsp" %>

<%
String src = HtmlUtil.escapeAttribute((String)request.getAttribute("liferay-ui:search-container-column-icon:src"));
boolean toggleRowChecker = GetterUtil.getBoolean(request.getAttribute("liferay-ui:search-container-column-icon:toggleRowChecker"));
%>

<c:if test="<%= Validator.isNotNull(src) %>">
	<div class="aspect-ratio-bg-cover <%= toggleRowChecker ? "click-selector" : StringPool.BLANK %> sticker sticker-static" style="background-image: url('<%= src %>');">
		<img alt="thumbnail" class="sr-only" src="<%= src %>" />
	</div>
</c:if>