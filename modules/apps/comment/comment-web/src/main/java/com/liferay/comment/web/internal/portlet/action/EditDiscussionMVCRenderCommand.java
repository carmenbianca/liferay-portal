/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.comment.web.internal.portlet.action;

import com.liferay.comment.web.internal.constants.CommentPortletKeys;
import com.liferay.portal.kernel.comment.Comment;
import com.liferay.portal.kernel.comment.CommentManager;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Lino Alves
 */
@Component(
	property = {
		"javax.portlet.name=" + CommentPortletKeys.COMMENT,
		"mvc.command.name=/discussion/edit_discussion"
	},
	service = MVCRenderCommand.class
)
public class EditDiscussionMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		long commentId = ParamUtil.getLong(renderRequest, "commentId");

		Comment comment = _commentManager.fetchComment(commentId);

		renderRequest.setAttribute(WebKeys.COMMENT, comment);

		return "/edit_discussion.jsp";
	}

	@Reference
	private CommentManager _commentManager;

}