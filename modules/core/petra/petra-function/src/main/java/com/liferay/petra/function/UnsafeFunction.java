/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.function;

/**
 * @author Shuyang Zhou
 */
@FunctionalInterface
public interface UnsafeFunction<T, R, E extends Throwable> {

	public R apply(T t) throws E;

}