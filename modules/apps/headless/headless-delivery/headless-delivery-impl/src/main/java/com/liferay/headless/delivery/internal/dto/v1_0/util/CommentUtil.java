/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.delivery.internal.dto.v1_0.util;

import com.liferay.headless.delivery.dto.v1_0.Comment;
import com.liferay.portal.kernel.comment.CommentManager;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

/**
 * @author Javier Gamarra
 */
public class CommentUtil {

	public static Comment toComment(
			com.liferay.portal.kernel.comment.Comment comment,
			CommentManager commentManager, Portal portal)
		throws Exception {

		if (comment == null) {
			return null;
		}

		return new Comment() {
			{
				creator = CreatorUtil.toCreator(portal, comment.getUser());
				dateCreated = comment.getCreateDate();
				dateModified = comment.getModifiedDate();
				id = comment.getCommentId();
				numberOfComments = commentManager.getChildCommentsCount(
					comment.getCommentId(), WorkflowConstants.STATUS_APPROVED);
				parentCommentId = comment.getParentCommentId();
				text = comment.getBody();
			}
		};
	}

}