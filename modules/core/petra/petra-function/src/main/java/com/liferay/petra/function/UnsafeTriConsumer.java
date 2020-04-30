/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.function;

/**
 * @author Brian Wing Shun Chan
 */
@FunctionalInterface
public interface UnsafeTriConsumer<A, B, C, T extends Throwable> {

	public void accept(A a, B b, C c) throws T;

}