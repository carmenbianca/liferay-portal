/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.concurrent;

import com.liferay.petra.lang.CentralizedThreadLocal;

/**
 * @author Shuyang Zhou
 */
public class ClearThreadLocalThreadPoolHandler
	extends ThreadPoolHandlerAdapter {

	@Override
	public void afterExecute(Runnable runnable, Throwable throwable) {
		CentralizedThreadLocal.clearShortLivedThreadLocals();
	}

}