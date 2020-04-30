/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.concurrent;

import java.util.concurrent.Future;

/**
 * @author Shuyang Zhou
 */
public interface NoticeableFuture<T> extends Future<T> {

	public boolean addFutureListener(FutureListener<T> futureListener);

	public boolean removeFutureListener(FutureListener<T> futureListener);

}