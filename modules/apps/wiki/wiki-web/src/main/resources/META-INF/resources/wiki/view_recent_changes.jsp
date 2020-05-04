<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/wiki/init.jsp" %>

<%
WikiNode node = (WikiNode)request.getAttribute(WikiWebKeys.WIKI_NODE);
%>

<liferay-util:include page="/wiki/top_links.jsp" servletContext="<%= application %>" />

<div class="main-content-body">
	<liferay-ui:header
		title="recent-changes"
	/>

	<liferay-util:include page="/wiki/page_iterator.jsp" servletContext="<%= application %>">
		<liferay-util:param name="navigation" value="recent-changes" />
	</liferay-util:include>

	<br />

	<c:if test="<%= wikiGroupServiceOverriddenConfiguration.enableRss() %>">
		<liferay-rss:rss
			delta="<%= GetterUtil.getInteger(wikiGroupServiceOverriddenConfiguration.rssDelta()) %>"
			displayStyle="<%= wikiGroupServiceOverriddenConfiguration.rssDisplayStyle() %>"
			feedType="<%= wikiGroupServiceOverriddenConfiguration.rssFeedType() %>"
			url='<%= themeDisplay.getPathMain() + "/wiki/rss?nodeId=" + node.getNodeId() %>'
		/>
	</c:if>
</div>