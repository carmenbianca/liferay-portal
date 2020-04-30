/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.concurrent;

/**
 * @author Shuyang Zhou
 */
public interface ThreadPoolHandler {

	public void afterExecute(Runnable runnable, Throwable throwable);

	public void beforeExecute(Thread thread, Runnable runnable);

	public void beforeThreadEnd(Thread thread);

	public void beforeThreadStart(Thread thread);

	public void terminated();

}