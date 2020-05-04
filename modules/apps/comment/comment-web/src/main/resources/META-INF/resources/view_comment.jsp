<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
long commentId = ParamUtil.getLong(request, "commentId");

Comment comment = CommentManagerUtil.fetchComment(commentId);
%>

<article class="lfr-discussion">
	<div class="lfr-discussion-details">
		<liferay-ui:user-display
			displayStyle="2"
			showUserName="<%= false %>"
			userId="<%= comment.getUserId() %>"
		/>
	</div>

	<div class="lfr-discussion-message">
		<header class="lfr-discussion-message-body">
			<%= comment.getTranslatedBody(themeDisplay.getPathThemeImages()) %>
		</header>
	</div>
</article>