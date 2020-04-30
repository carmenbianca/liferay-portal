/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mentions.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.social.kernel.util.SocialInteractionsConfiguration;

import java.util.List;

/**
 * @author Sergio González
 */
public interface MentionsUserFinder {

	public List<User> getUsers(
			long companyId, long userId, String query,
			SocialInteractionsConfiguration socialInteractionsConfiguration)
		throws PortalException;

}