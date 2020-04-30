/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.function;

/**
 * @author Shuyang Zhou
 */
@FunctionalInterface
public interface UnsafeBiFunction<T, U, R, E extends Throwable> {

	public R apply(T t, U u) throws E;

}