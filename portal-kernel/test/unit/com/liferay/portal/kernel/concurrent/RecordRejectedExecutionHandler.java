/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.concurrent;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Shuyang Zhou
 */
public class RecordRejectedExecutionHandler
	implements RejectedExecutionHandler {

	public List<Runnable> getRejectedList() {
		return _rejectedList;
	}

	@Override
	public void rejectedExecution(
		Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {

		_rejectedList.add(runnable);
	}

	private final List<Runnable> _rejectedList = new CopyOnWriteArrayList<>();

}