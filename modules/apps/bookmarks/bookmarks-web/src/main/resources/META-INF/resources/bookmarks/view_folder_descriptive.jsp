<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/bookmarks/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

BookmarksFolder folder = (BookmarksFolder)row.getObject();

folder = folder.toEscapedModel();

PortletURL rowURL = liferayPortletResponse.createRenderURL();

rowURL.setParameter("mvcRenderCommandName", "/bookmarks/view_folder");
rowURL.setParameter("redirect", currentURL);
rowURL.setParameter("folderId", String.valueOf(folder.getFolderId()));
%>

<h4>
	<aui:a href="<%= rowURL.toString() %>">
		<%= folder.getName() %>
	</aui:a>
</h4>

<h5 class="text-default">
	<%= folder.getDescription() %>
</h5>

<%
int foldersCount = BookmarksFolderServiceUtil.getFoldersCount(scopeGroupId, folder.getFolderId());
int entriesCount = BookmarksEntryServiceUtil.getEntriesCount(scopeGroupId, folder.getFolderId());
%>

<span class="h6">
	<liferay-ui:message arguments="<%= foldersCount %>" key='<%= (foldersCount == 1) ? "x-folder" : "x-folders" %>' />
</span>
<span class="h6">
	<liferay-ui:message arguments="<%= entriesCount %>" key='<%= (entriesCount == 1) ? "x-bookmark" : "x-bookmarks" %>' />
</span>