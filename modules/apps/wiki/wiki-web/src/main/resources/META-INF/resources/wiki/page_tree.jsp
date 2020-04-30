<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/wiki/init.jsp" %>

<%
WikiPage parentPage = (WikiPage)request.getAttribute(WikiWebKeys.WIKI_TREE_WALKER_PARENT);
WikiPage wikiPage = (WikiPage)request.getAttribute(WikiWebKeys.WIKI_TREE_WALKER_PAGE);
int depth = (Integer)request.getAttribute(WikiWebKeys.WIKI_TREE_WALKER_DEPTH);

String preface = StringPool.BLANK;

for (int i = 0; i < depth; i++) {
	preface += "- ";
}

List<WikiPage> childPages = ListUtil.copy(parentPage.getViewableChildPages());

childPages.remove(wikiPage);

childPages = ListUtil.sort(childPages);
%>

<aui:option label="<%= preface + parentPage.getTitle() %>" selected="<%= parentPage.getTitle().equals(wikiPage.getParentTitle()) %>" value="<%= parentPage.getTitle() %>" />

<%
for (WikiPage childPage : childPages) {
	if (Validator.isNull(childPage.getRedirectTitle())) {
		request.setAttribute(WikiWebKeys.WIKI_TREE_WALKER_DEPTH, depth + 1);
		request.setAttribute(WikiWebKeys.WIKI_TREE_WALKER_PAGE, wikiPage);
		request.setAttribute(WikiWebKeys.WIKI_TREE_WALKER_PARENT, childPage);
%>

		<liferay-util:include page="/wiki/page_tree.jsp" servletContext="<%= application %>" />

<%
	}
}
%>