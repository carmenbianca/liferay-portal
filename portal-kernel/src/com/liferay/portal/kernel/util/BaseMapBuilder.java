/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

/**
 * @author Hugo Huijser
 */
public class BaseMapBuilder {

	@FunctionalInterface
	public interface UnsafeFunction<T, R, E extends Throwable> {

		public R apply(T t) throws E;

	}

	@FunctionalInterface
	public interface UnsafeSupplier<T, E extends Throwable> {

		public T get() throws E;

	}

}