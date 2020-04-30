<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
DLItemSelectorViewDisplayContext dlItemSelectorViewDisplayContext = (DLItemSelectorViewDisplayContext)request.getAttribute(DLItemSelectorWebKeys.DL_ITEM_SELECTOR_VIEW_DISPLAY_CONTEXT);
%>

<liferay-item-selector:repository-entry-browser
	emptyResultsMessage='<%= LanguageUtil.get(request, "there-are-no-documents-or-media-files-in-this-folder") %>'
	extensions="<%= ListUtil.toList(dlItemSelectorViewDisplayContext.getExtensions()) %>"
	itemSelectedEventName="<%= dlItemSelectorViewDisplayContext.getItemSelectedEventName() %>"
	itemSelectorReturnTypeResolver="<%= dlItemSelectorViewDisplayContext.getItemSelectorReturnTypeResolver() %>"
	maxFileSize="<%= DLValidatorUtil.getMaxAllowableSize() %>"
	portletURL="<%= dlItemSelectorViewDisplayContext.getPortletURL(liferayPortletResponse) %>"
	repositoryEntries="<%= dlItemSelectorViewDisplayContext.getRepositoryEntries() %>"
	repositoryEntriesCount="<%= dlItemSelectorViewDisplayContext.getRepositoryEntriesCount() %>"
	showBreadcrumb="<%= true %>"
	showDragAndDropZone="<%= dlItemSelectorViewDisplayContext.isShowDragAndDropZone() %>"
	tabName="<%= dlItemSelectorViewDisplayContext.getTitle() %>"
	uploadURL="<%= dlItemSelectorViewDisplayContext.getUploadURL(liferayPortletResponse) %>"
/>