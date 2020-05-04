<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
BlogsItemSelectorViewDisplayContext blogsItemSelectorViewDisplayContext = (BlogsItemSelectorViewDisplayContext)request.getAttribute(BlogsItemSelectorWebKeys.BLOGS_ITEM_SELECTOR_VIEW_DISPLAY_CONTEXT);

int cur = ParamUtil.getInteger(request, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);
int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);

int[] startAndEnd = SearchPaginationUtil.calculateStartAndEnd(cur, delta);

int start = startAndEnd[0];
int end = startAndEnd[1];

Folder folder = blogsItemSelectorViewDisplayContext.fetchAttachmentsFolder(themeDisplay.getUserId(), scopeGroupId);

List portletFileEntries = null;
int portletFileEntriesCount = 0;

if (folder != null) {
	if (blogsItemSelectorViewDisplayContext.isSearch()) {
		SearchContext searchContext = SearchContextFactory.getInstance(request);

		searchContext.setEnd(end);
		searchContext.setFolderIds(new long[] {folder.getFolderId()});
		searchContext.setStart(start);

		Hits hits = PortletFileRepositoryUtil.searchPortletFileEntries(folder.getRepositoryId(), searchContext);

		portletFileEntriesCount = hits.getLength();

		Document[] docs = hits.getDocs();

		portletFileEntries = new ArrayList(docs.length);

		for (Document doc : docs) {
			long fileEntryId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));

			FileEntry fileEntry = null;

			try {
				fileEntry = PortletFileRepositoryUtil.getPortletFileEntry(fileEntryId);
			}
			catch (Exception e) {
				if (_log.isWarnEnabled()) {
					_log.warn("Documents and Media search index is stale and contains file entry {" + fileEntryId + "}");
				}

				continue;
			}

			portletFileEntries.add(fileEntry);
		}
	}
	else {
		portletFileEntries = PortletFileRepositoryUtil.getPortletFileEntries(scopeGroupId, folder.getFolderId(), WorkflowConstants.STATUS_APPROVED, start, end, blogsItemSelectorViewDisplayContext.getOrderByComparator());
		portletFileEntriesCount = PortletFileRepositoryUtil.getPortletFileEntriesCount(scopeGroupId, folder.getFolderId(), WorkflowConstants.STATUS_APPROVED);
	}
}
%>

<liferay-item-selector:repository-entry-browser
	emptyResultsMessage='<%= LanguageUtil.get(resourceBundle, "there-are-no-blog-attachments") %>'
	extensions="<%= ListUtil.fromArray(blogsItemSelectorViewDisplayContext.getImageExtensions()) %>"
	itemSelectedEventName="<%= blogsItemSelectorViewDisplayContext.getItemSelectedEventName() %>"
	itemSelectorReturnTypeResolver="<%= blogsItemSelectorViewDisplayContext.getItemSelectorReturnTypeResolver() %>"
	maxFileSize="<%= blogsItemSelectorViewDisplayContext.getImageMaxSize() %>"
	portletURL="<%= blogsItemSelectorViewDisplayContext.getPortletURL(request, liferayPortletResponse) %>"
	repositoryEntries="<%= portletFileEntries %>"
	repositoryEntriesCount="<%= portletFileEntriesCount %>"
	showDragAndDropZone="<%= true %>"
	tabName="<%= blogsItemSelectorViewDisplayContext.getTitle(locale) %>"
	uploadURL="<%= blogsItemSelectorViewDisplayContext.getUploadURL(liferayPortletResponse) %>"
/>

<%!
private static Log _log = LogFactoryUtil.getLog("com_liferay_blogs_item_selector_web.blogs_attachments_jsp");
%>