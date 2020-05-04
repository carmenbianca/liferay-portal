/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Shuyang Zhou
 */
public class BaseFutureListener<T> implements FutureListener<T> {

	@Override
	public final void complete(Future<T> future) {
		if (future.isCancelled()) {
			completeWithCancel(future);

			return;
		}

		try {
			completeWithResult(future, future.get());
		}
		catch (Throwable t) {
			if (t instanceof ExecutionException) {
				t = t.getCause();
			}

			completeWithException(future, t);
		}
	}

	public void completeWithCancel(Future<T> future) {
	}

	public void completeWithException(Future<T> future, Throwable throwable) {
	}

	public void completeWithResult(Future<T> future, T result) {
	}

}