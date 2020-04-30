/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.memory;

/**
 * @author Shuyang Zhou
 */
public interface PoolAction<O, I> {

	public O onBorrow(O output, I input);

	public O onCreate(I input);

	public void onReturn(O output);

}