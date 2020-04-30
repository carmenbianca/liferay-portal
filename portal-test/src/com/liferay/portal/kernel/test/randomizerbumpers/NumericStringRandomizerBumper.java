/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.test.randomizerbumpers;

import com.liferay.portal.kernel.util.Validator;

/**
 * @author Shuyang Zhou
 */
public class NumericStringRandomizerBumper implements RandomizerBumper<String> {

	public static final NumericStringRandomizerBumper INSTANCE =
		new NumericStringRandomizerBumper();

	@Override
	public boolean accept(String randomValue) {
		return !Validator.isNumber(randomValue);
	}

}