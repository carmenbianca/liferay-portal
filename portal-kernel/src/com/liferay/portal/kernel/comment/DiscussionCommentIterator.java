/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.comment;

import java.util.Iterator;

/**
 * @author Adolfo Pérez
 */
public interface DiscussionCommentIterator extends Iterator<DiscussionComment> {

	public int getIndexPage();

}