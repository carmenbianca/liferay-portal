/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.comment.demo.data.creator;

import com.liferay.portal.kernel.comment.Comment;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ClassedModel;

/**
 * @author Alejandro Hernández
 */
public interface CommentDemoDataCreator {

	public Comment create(long userId, ClassedModel classedModel)
		throws PortalException;

	public Comment create(long userId, long parentCommentId)
		throws PortalException;

	public void delete() throws PortalException;

}