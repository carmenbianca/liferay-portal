/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.module.framework;

import com.liferay.petra.reflect.ReflectionUtil;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Shuyang Zhou
 */
public class ThrowableCollector {

	public void collect(Throwable t) {
		while (true) {
			Throwable throwable = _atomicReference.get();

			if (throwable != null) {
				throwable.addSuppressed(t);

				break;
			}

			if (_atomicReference.compareAndSet(null, t)) {
				break;
			}
		}
	}

	public Throwable getThrowable() {
		return _atomicReference.get();
	}

	public void rethrow() {
		Throwable throwable = _atomicReference.get();

		if (throwable != null) {
			ReflectionUtil.throwException(throwable);
		}
	}

	private final AtomicReference<Throwable> _atomicReference =
		new AtomicReference<>();

}