/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.comment;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Adolfo Pérez
 */
@ProviderType
public interface Discussion {

	public int getDiscussionCommentsCount();

	public DiscussionComment getRootDiscussionComment();

	public boolean isMaxCommentsLimitExceeded();

}