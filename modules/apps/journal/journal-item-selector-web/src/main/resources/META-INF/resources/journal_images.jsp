<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
JournalItemSelectorViewDisplayContext journalItemSelectorViewDisplayContext = (JournalItemSelectorViewDisplayContext)request.getAttribute(JournalItemSelectorWebKeys.JOURNAL_ITEM_SELECTOR_VIEW_DISPLAY_CONTEXT);

int cur = ParamUtil.getInteger(request, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);
int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);

int[] startAndEnd = SearchPaginationUtil.calculateStartAndEnd(cur, delta);

int start = startAndEnd[0];
int end = startAndEnd[1];

JournalArticle journalArticle = journalItemSelectorViewDisplayContext.getJournalArticle();

List portletFileEntries = null;
int portletFileEntriesCount = 0;

if (journalArticle != null) {
	portletFileEntries = journalArticle.getImagesFileEntries(start, end, journalItemSelectorViewDisplayContext.getOrderByComparator());
	portletFileEntriesCount = journalArticle.getImagesFileEntriesCount();
}
%>

<liferay-item-selector:repository-entry-browser
	emptyResultsMessage='<%= LanguageUtil.get(resourceBundle, "there-are-no-journal-images") %>'
	itemSelectedEventName="<%= journalItemSelectorViewDisplayContext.getItemSelectedEventName() %>"
	itemSelectorReturnTypeResolver="<%= journalItemSelectorViewDisplayContext.getItemSelectorReturnTypeResolver() %>"
	maxFileSize="<%= DLValidatorUtil.getMaxAllowableSize() %>"
	portletURL="<%= journalItemSelectorViewDisplayContext.getPortletURL(request, liferayPortletResponse) %>"
	repositoryEntries="<%= portletFileEntries %>"
	repositoryEntriesCount="<%= portletFileEntriesCount %>"
	showSearch="<%= false %>"
	tabName="<%= journalItemSelectorViewDisplayContext.getTitle(locale) %>"
	uploadURL="<%= journalItemSelectorViewDisplayContext.getUploadURL(liferayPortletResponse) %>"
/>