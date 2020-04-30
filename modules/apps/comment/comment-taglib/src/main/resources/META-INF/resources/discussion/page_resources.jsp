<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/discussion/init.jsp" %>

<%
int index = GetterUtil.getInteger(request.getAttribute("liferay-comment:discussion:index"));
int initialIndex = GetterUtil.getInteger(request.getAttribute("liferay-comment:discussion:index"));
int rootIndexPage = GetterUtil.getInteger(request.getAttribute("liferay-comment:discussion:rootIndexPage"));

DiscussionRequestHelper discussionRequestHelper = new DiscussionRequestHelper(request);
DiscussionTaglibHelper discussionTaglibHelper = new DiscussionTaglibHelper(request);

Discussion discussion = CommentManagerUtil.getDiscussion(discussionTaglibHelper.getUserId(), discussionRequestHelper.getScopeGroupId(), discussionTaglibHelper.getClassName(), discussionTaglibHelper.getClassPK(), new ServiceContextFunction(request));

DiscussionComment rootDiscussionComment = (discussion == null) ? null : discussion.getRootDiscussionComment();

DiscussionCommentIterator discussionCommentIterator = (rootDiscussionComment == null) ? null : rootDiscussionComment.getThreadDiscussionCommentIterator(rootIndexPage - 1);

if (discussionCommentIterator != null) {
	while (discussionCommentIterator.hasNext()) {
		rootIndexPage = discussionCommentIterator.getIndexPage();

		if (index >= (initialIndex + PropsValues.DISCUSSION_COMMENTS_DELTA_VALUE)) {
			break;
		}

		request.setAttribute("liferay-comment:discussion:depth", 0);
		request.setAttribute("liferay-comment:discussion:discussion", discussion);
		request.setAttribute("liferay-comment:discussion:discussionComment", discussionCommentIterator.next());
%>

		<liferay-util:include page="/discussion/view_message_thread.jsp" servletContext="<%= application %>" />

<%
		index = GetterUtil.getInteger(request.getAttribute("liferay-comment:discussion:index"));
	}
}
%>

<script>
	var indexInput = document.getElementById('<%= namespace %>index');

	if (indexInput) {
		indexInput.value = '<%= String.valueOf(index) %>';
	}

	var rootIndexPageInput = document.getElementById(
		'<%= namespace %>rootIndexPage'
	);

	if (rootIndexPageInput) {
		rootIndexPageInput.value = '<%= String.valueOf(rootIndexPage) %>';
	}

	<c:if test="<%= (rootDiscussionComment != null) && (discussion.getDiscussionCommentsCount() <= index) %>">
		var moreCommentsContainer = document.getElementById(
			'<%= namespace %>moreCommentsContainer'
		);

		if (moreCommentsContainer) {
			moreCommentsContainer.classList.add('hide');
		}
	</c:if>
</script>