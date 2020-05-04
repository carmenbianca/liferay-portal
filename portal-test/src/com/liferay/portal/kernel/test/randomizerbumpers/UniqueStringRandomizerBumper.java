/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.test.randomizerbumpers;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Shuyang Zhou
 */
public class UniqueStringRandomizerBumper implements RandomizerBumper<String> {

	public static final UniqueStringRandomizerBumper INSTANCE =
		new UniqueStringRandomizerBumper();

	public static void reset() {
		_randomValues.clear();
	}

	@Override
	public boolean accept(String randomValue) {
		return _randomValues.add(randomValue);
	}

	private static final Set<String> _randomValues = Collections.newSetFromMap(
		new ConcurrentHashMap<>());

}