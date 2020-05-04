/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.internal.lar;

import com.liferay.exportimport.kernel.lar.UserIdStrategy;
import com.liferay.portal.kernel.model.User;

/**
 * @author Bruno Farache
 */
public class AlwaysCurrentUserIdStrategy implements UserIdStrategy {

	public AlwaysCurrentUserIdStrategy(User user) {
		_user = user;
	}

	@Override
	public long getUserId(String userUuid) {
		return _user.getUserId();
	}

	private final User _user;

}