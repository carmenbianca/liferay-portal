/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mentions.strategy;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;

import java.util.List;

/**
 * @author Cristina González
 */
public interface MentionsStrategy {

	public List<User> getUsers(
			long companyId, long user, String query, JSONObject jsonObject)
		throws PortalException;

}