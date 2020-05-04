<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/bookmarks/init.jsp" %>

<%
BookmarksEntry entry = (BookmarksEntry)request.getAttribute(BookmarksWebKeys.BOOKMARKS_ENTRY);

int status = ParamUtil.getInteger(request, "status", WorkflowConstants.STATUS_ANY);
%>

<aui:a href='<%= themeDisplay.getPathMain() + "/bookmarks/open_entry?entryId=" + entry.getEntryId() + ((status != WorkflowConstants.STATUS_ANY) ? "&status=" + status : StringPool.BLANK) %>' target="_blank"><%= HtmlUtil.escape(entry.getName()) %> (<%= HtmlUtil.escape(entry.getUrl()) %>)</aui:a>

<p class="asset-description"><%= HtmlUtil.escape(entry.getDescription()) %></p>

<liferay-expando:custom-attributes-available
	className="<%= BookmarksEntry.class.getName() %>"
>
	<liferay-expando:custom-attribute-list
		className="<%= BookmarksEntry.class.getName() %>"
		classPK="<%= (entry != null) ? entry.getEntryId() : 0 %>"
		editable="<%= false %>"
		label="<%= true %>"
	/>
</liferay-expando:custom-attributes-available>