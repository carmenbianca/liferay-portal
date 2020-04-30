<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
MicroblogsEntry microblogsEntry = (MicroblogsEntry)request.getAttribute(WebKeys.MICROBLOGS_ENTRY);
%>

<div class="asset-summary">
	<%= HtmlUtil.stripHtml(microblogsEntry.getContent()) %>
</div>