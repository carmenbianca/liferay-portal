/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.concurrent;

import java.util.concurrent.Future;

/**
 * @author Shuyang Zhou
 */
public interface FutureListener<T> {

	public void complete(Future<T> future);

}