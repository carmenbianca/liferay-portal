<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String randomNamespace = PortalUtil.generateRandomKey(request, "discussion_full_content") + StringPool.UNDERLINE;

Comment comment = (Comment)request.getAttribute(WebKeys.COMMENT);

Comment parentComment = CommentManagerUtil.fetchComment(comment.getParentCommentId());

WorkflowableComment workflowableComment = null;

if (comment instanceof WorkflowableComment) {
	workflowableComment = (WorkflowableComment)comment;
}
%>

<table class="lfr-grid lfr-table">
	<tr>
		<td colspan="2" id="<%= randomNamespace %>messageScroll<%= comment.getCommentId() %>">
			<a name="<%= randomNamespace %>message_<%= comment.getCommentId() %>"></a>
		</td>
	</tr>
	<tr>
		<td class="lfr-center lfr-top">
			<liferay-ui:user-display
				displayStyle="2"
				userId="<%= comment.getUserId() %>"
				userName="<%= HtmlUtil.escape(comment.getUserName()) %>"
			/>
		</td>
		<td class="lfr-top stretch">
			<c:if test="<%= (workflowableComment != null) && (workflowableComment.getStatus() != WorkflowConstants.STATUS_APPROVED) %>">
				<aui:model-context bean="<%= comment %>" model="<%= comment.getModelClass() %>" />

				<div>
					<aui:workflow-status model="<%= CommentConstants.getDiscussionClass() %>" status="<%= workflowableComment.getStatus() %>" />
				</div>
			</c:if>

			<div>
				<%= comment.getTranslatedBody(themeDisplay.getPathThemeImages()) %>
			</div>

			<br />

			<div>
				<c:if test="<%= (parentComment != null) && parentComment.isRoot() %>">
					<liferay-ui:message arguments="<%= dateFormatDateTime.format(comment.getModifiedDate()) %>" key="posted-on-x" translateArguments="<%= false %>" />
				</c:if>
			</div>
		</td>
	</tr>
</table>

<c:if test="<%= (parentComment != null) && !parentComment.isRoot() %>">
	<h3><liferay-ui:message key="replying-to" />:</h3>

	<%
	request.setAttribute(WebKeys.COMMENT, parentComment);
	%>

	<liferay-util:include page="/comments/asset/discussion_full_content.jsp" />
</c:if>