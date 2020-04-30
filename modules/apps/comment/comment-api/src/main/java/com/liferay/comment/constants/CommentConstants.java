/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.comment.constants;

import com.liferay.message.boards.model.MBDiscussion;

/**
 * @author Adolfo Pérez
 */
public class CommentConstants {

	public static Class<?> getDiscussionClass() {
		return MBDiscussion.class;
	}

	public static String getDiscussionClassName() {
		return MBDiscussion.class.getName();
	}

}