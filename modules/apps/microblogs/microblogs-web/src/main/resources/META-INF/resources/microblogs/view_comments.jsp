<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String tabs1 = ParamUtil.getString(request, "tabs1", "timeline");

int cur = ParamUtil.getInteger(request, SearchContainer.DEFAULT_CUR_PARAM);

long parentMicroblogsEntryId = ParamUtil.getLong(request, "parentMicroblogsEntryId");

List<MicroblogsEntry> microblogsEntries = MicroblogsEntryLocalServiceUtil.getParentMicroblogsEntryMicroblogsEntries(MicroblogsEntryConstants.TYPE_REPLY, parentMicroblogsEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, new EntryCreateDateComparator(true));

request.setAttribute(WebKeys.MICROBLOGS_ENTRIES, microblogsEntries);

PortletURL microblogsEntriesURL = renderResponse.createRenderURL();

microblogsEntriesURL.setWindowState(WindowState.NORMAL);

microblogsEntriesURL.setParameter("mvcPath", "/microblogs/view.jsp");
microblogsEntriesURL.setParameter("tabs1", tabs1);
microblogsEntriesURL.setParameter("cur", String.valueOf(cur));

request.setAttribute(WebKeys.MICROBLOGS_ENTRIES_URL, microblogsEntriesURL);
%>

<div class="comments-container-content">

	<%
	request.setAttribute("view_comments.jsp-comment", "true");
	request.setAttribute("view_comments.jsp-parentMicroblogsEntryId", parentMicroblogsEntryId);
	%>

	<c:if test="<%= !microblogsEntries.isEmpty() %>">
		<liferay-util:include page="/microblogs/view_microblogs_entries.jsp" servletContext="<%= application %>" />
	</c:if>

	<c:if test="<%= MicroblogsPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_ENTRY) %>">
		<liferay-util:include page="/microblogs/edit_microblogs_entry.jsp" servletContext="<%= application %>" />
	</c:if>
</div>