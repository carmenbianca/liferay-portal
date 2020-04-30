/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.concurrent;

import java.util.concurrent.Future;

/**
 * @author Shuyang Zhou
 * @author Preston Crary
 */
public class TestFutureListener<T> implements FutureListener<T> {

	@Override
	public void complete(Future<T> future) {
		_count++;
		_future = future;
	}

	public int getCount() {
		return _count;
	}

	public Future<T> getFuture() {
		return _future;
	}

	private int _count;
	private Future<T> _future;

}