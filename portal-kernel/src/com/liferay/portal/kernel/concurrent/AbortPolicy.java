/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.concurrent;

import java.util.concurrent.RejectedExecutionException;

/**
 * Implements the same behavior as {@link
 * java.util.concurrent.ThreadPoolExecutor.AbortPolicy}.
 *
 * @author Shuyang Zhou
 * @see    java.util.concurrent.ThreadPoolExecutor.AbortPolicy
 */
public class AbortPolicy implements RejectedExecutionHandler {

	/**
	 * @see java.util.concurrent.ThreadPoolExecutor.AbortPolicy#rejectedExecution(
	 *      Runnable, java.util.concurrent.ThreadPoolExecutor)
	 */
	@Override
	public void rejectedExecution(
		Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {

		throw new RejectedExecutionException();
	}

}