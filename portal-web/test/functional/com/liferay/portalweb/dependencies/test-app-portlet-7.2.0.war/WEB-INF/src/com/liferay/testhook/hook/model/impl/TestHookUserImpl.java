/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.testhook.hook.model.impl;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserWrapper;

/**
 * @author Brian Wing Shun Chan
 */
public class TestHookUserImpl extends UserWrapper {

	public TestHookUserImpl(User user) {
		super(user);
	}

	public String getFavoriteColor() {
		return "Blue";
	}

}