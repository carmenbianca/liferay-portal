/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.test;

import com.liferay.petra.reflect.ReflectionUtil;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author Shuyang Zhou
 */
public class SyncThrowableThread<V> extends Thread {

	public SyncThrowableThread(Callable<V> callable) {
		_futureTask = new FutureTask<>(callable);
	}

	@Override
	public void run() {
		_futureTask.run();
	}

	public V sync() {
		try {
			join();

			return _futureTask.get();
		}
		catch (Throwable t) {
			return ReflectionUtil.throwException(t);
		}
	}

	private final FutureTask<V> _futureTask;

}