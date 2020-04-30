/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.test.util;

import com.liferay.exportimport.kernel.lar.UserIdStrategy;
import com.liferay.portal.kernel.test.util.TestPropsValues;

/**
 * @author Máté Thurzó
 */
public class TestUserIdStrategy implements UserIdStrategy {

	@Override
	public long getUserId(String userUuid) {
		try {
			return TestPropsValues.getUserId();
		}
		catch (Exception exception) {
			return 0;
		}
	}

}