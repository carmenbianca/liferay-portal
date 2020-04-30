/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Shuyang Zhou
 */
public class RecordUncaughtExceptionHandler
	implements Thread.UncaughtExceptionHandler {

	public Map<Thread, Throwable> getUncaughtMap() {
		return _uncaughtMap;
	}

	@Override
	public void uncaughtException(Thread thread, Throwable throwable) {
		_uncaughtMap.put(thread, throwable);
	}

	private final Map<Thread, Throwable> _uncaughtMap =
		new ConcurrentHashMap<>();

}