<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/article/init.jsp" %>

<div id="<portlet:namespace />message-container"></div>

<div class="kb-article-container">
	<liferay-util:include page="/admin/common/view_article.jsp" servletContext="<%= application %>" />
</div>