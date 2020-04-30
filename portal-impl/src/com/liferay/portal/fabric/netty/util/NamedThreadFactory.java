/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.fabric.netty.util;

import com.liferay.petra.string.StringPool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Shuyang Zhou
 */
public class NamedThreadFactory implements ThreadFactory {

	public NamedThreadFactory(String name) {
		_name = name;
	}

	@Override
	public Thread newThread(Runnable runnable) {
		Thread thread = new Thread(
			runnable,
			_name.concat(
				StringPool.MINUS
			).concat(
				String.valueOf(_counter.incrementAndGet())
			));

		thread.setDaemon(true);

		return thread;
	}

	private final AtomicInteger _counter = new AtomicInteger();
	private final String _name;

}