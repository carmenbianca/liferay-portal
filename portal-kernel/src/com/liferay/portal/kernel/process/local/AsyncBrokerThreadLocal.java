/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.process.local;

import com.liferay.petra.lang.CentralizedThreadLocal;
import com.liferay.portal.kernel.concurrent.AsyncBroker;

import java.io.Serializable;

/**
 * @author Shuyang Zhou
 */
public class AsyncBrokerThreadLocal {

	public static AsyncBroker<Long, Serializable> getAsyncBroker() {
		AsyncBroker<Long, Serializable> asyncBroker =
			_asyncBrokerThreadLocal.get();

		if (asyncBroker == null) {
			throw new IllegalStateException("Async broker is not set");
		}

		return asyncBroker;
	}

	public static void removeAsyncBroker() {
		_asyncBrokerThreadLocal.remove();
	}

	public static void setAsyncBroker(
		AsyncBroker<Long, Serializable> asyncBroker) {

		_asyncBrokerThreadLocal.set(asyncBroker);
	}

	private static final ThreadLocal<AsyncBroker<Long, Serializable>>
		_asyncBrokerThreadLocal = new CentralizedThreadLocal<>(false);

}