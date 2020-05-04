<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/wiki/init.jsp" %>

<%
WikiNode node = (WikiNode)request.getAttribute(WikiWebKeys.WIKI_NODE);
WikiPage wikiPage = (WikiPage)request.getAttribute(WikiWebKeys.WIKI_PAGE);

PortletURL viewPageURL = renderResponse.createRenderURL();

viewPageURL.setParameter("mvcRenderCommandName", "/wiki/view");
viewPageURL.setParameter("nodeName", node.getName());
viewPageURL.setParameter("title", wikiPage.getTitle());

PortletURL viewPageHistoryURL = renderResponse.createRenderURL();

viewPageHistoryURL.setParameter("mvcRenderCommandName", "/wiki/view_page_history");
viewPageHistoryURL.setParameter("redirect", viewPageURL.toString());
viewPageHistoryURL.setParameter("nodeId", String.valueOf(node.getNodeId()));
viewPageHistoryURL.setParameter("title", wikiPage.getTitle());

PortletURL viewPageActivitiesURL = PortletURLUtil.clone(viewPageHistoryURL, renderResponse);

viewPageActivitiesURL.setParameter("mvcRenderCommandName", "/wiki/view_page_activities");
%>

<liferay-ui:tabs
	names="activities,versions"
	param="tabs3"
	urls="<%= new String[] {viewPageActivitiesURL.toString(), viewPageHistoryURL.toString()} %>"
/>