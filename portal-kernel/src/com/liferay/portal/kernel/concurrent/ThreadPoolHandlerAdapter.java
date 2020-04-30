/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.concurrent;

/**
 * @author Shuyang Zhou
 */
public class ThreadPoolHandlerAdapter implements ThreadPoolHandler {

	@Override
	public void afterExecute(Runnable runnable, Throwable throwable) {
	}

	@Override
	public void beforeExecute(Thread thread, Runnable runnable) {
	}

	@Override
	public void beforeThreadEnd(Thread thread) {
	}

	@Override
	public void beforeThreadStart(Thread thread) {
	}

	@Override
	public void terminated() {
	}

}