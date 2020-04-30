<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/taglib/ui/search_container/init.jsp" %>

<%
String href = (String)request.getAttribute("liferay-ui:search-container-column-icon:href");
String icon = (String)request.getAttribute("liferay-ui:search-container-column-icon:icon");
boolean toggleRowChecker = GetterUtil.getBoolean(request.getAttribute("liferay-ui:search-container-column-icon:toggleRowChecker"));
%>

<div class="<%= toggleRowChecker ? "click-selector" : StringPool.BLANK %> sticker sticker-secondary sticker-static">
	<aui:icon image="<%= icon %>" markupView="lexicon" url="<%= href %>" />
</div>