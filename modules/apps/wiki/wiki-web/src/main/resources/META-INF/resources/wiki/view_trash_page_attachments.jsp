<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/wiki/init.jsp" %>

<%
WikiPage wikiPage = (WikiPage)request.getAttribute(WikiWebKeys.WIKI_PAGE);
WikiNode node = (WikiNode)request.getAttribute(WikiWebKeys.WIKI_NODE);
%>

<portlet:actionURL name="/wiki/edit_page_attachment" var="undoTrashURL">
	<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.RESTORE %>" />
</portlet:actionURL>

<div class="container-fluid-1280">
	<liferay-trash:undo
		portletURL="<%= undoTrashURL %>"
	/>

	<c:if test="<%= WikiNodePermission.contains(permissionChecker, node, ActionKeys.ADD_ATTACHMENT) %>">
		<portlet:actionURL name="/wiki/edit_page_attachment" var="emptyTrashURL">
			<portlet:param name="nodeId" value="<%= String.valueOf(wikiPage.getNodeId()) %>" />
			<portlet:param name="title" value="<%= wikiPage.getTitle() %>" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
		</portlet:actionURL>

		<%
		String trashEntriesMaxAgeTimeDescription = LanguageUtil.getTimeDescription(locale, trashHelper.getMaxAge(themeDisplay.getScopeGroup()) * Time.MINUTE, true);
		%>

		<liferay-trash:empty
			confirmMessage="are-you-sure-you-want-to-remove-the-attachments-for-this-page"
			emptyMessage="remove-the-attachments-for-this-page"
			infoMessage='<%= LanguageUtil.format(request, "attachments-that-have-been-removed-for-more-than-x-will-be-automatically-deleted", trashEntriesMaxAgeTimeDescription, false) %>'
			portletURL="<%= emptyTrashURL.toString() %>"
			totalEntries="<%= wikiPage.getDeletedAttachmentsFileEntriesCount() %>"
		/>
	</c:if>

	<%
	List<FileEntry> attachmentsFileEntries = wikiPage.getDeletedAttachmentsFileEntries();
	int attachmentsFileEntriesCount = wikiPage.getDeletedAttachmentsFileEntriesCount();
	String emptyResultsMessage = "this-page-does-not-have-file-attachments-in-the-recycle-bin";

	PortletURL iteratorURL = renderResponse.createRenderURL();

	iteratorURL.setParameter("mvcRenderCommandName", "/wiki/view_trash_page_attachments");
	iteratorURL.setParameter("redirect", currentURL);
	iteratorURL.setParameter("nodeId", String.valueOf(wikiPage.getNodeId()));
	iteratorURL.setParameter("title", wikiPage.getTitle());
	iteratorURL.setWindowState(LiferayWindowState.POP_UP);

	boolean paginate = false;
	boolean showPageAttachmentAction = true;
	int status = WorkflowConstants.STATUS_IN_TRASH;
	%>

	<%@ include file="/wiki/attachments_list.jspf" %>
</div>