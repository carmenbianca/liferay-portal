/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.concurrent;

/**
 * Implements the same behavior as {@link
 * java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy}.
 *
 * @author Shuyang Zhou
 * @see    java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy
 */
public class DiscardOldestPolicy implements RejectedExecutionHandler {

	/**
	 * @see java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy#rejectedExecution(
	 *      Runnable, java.util.concurrent.ThreadPoolExecutor)
	 */
	@Override
	public void rejectedExecution(
		Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {

		if (threadPoolExecutor.isShutdown()) {
			return;
		}

		TaskQueue<Runnable> taskQueue = threadPoolExecutor.getTaskQueue();

		taskQueue.poll();

		threadPoolExecutor.execute(runnable);
	}

}