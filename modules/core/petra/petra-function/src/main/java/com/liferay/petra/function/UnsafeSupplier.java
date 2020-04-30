/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.function;

/**
 * @author Preston Crary
 */
@FunctionalInterface
public interface UnsafeSupplier<T, E extends Throwable> {

	public T get() throws E;

}