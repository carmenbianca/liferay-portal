/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.backgroundtask;

import com.liferay.petra.lang.CentralizedThreadLocal;
import com.liferay.petra.lang.SafeClosable;

/**
 * @author Michael C. Han
 */
public class BackgroundTaskThreadLocal {

	public static long getBackgroundTaskId() {
		return _backgroundTaskId.get();
	}

	public static boolean hasBackgroundTask() {
		long backgroundTaskId = getBackgroundTaskId();

		if (backgroundTaskId > 0) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #setBackgroundTaskIdWithSafeClosable(long)}
	 */
	@Deprecated
	public static void setBackgroundTaskId(long backgroundTaskId) {
		if (backgroundTaskId > 0) {
			_backgroundTaskId.set(backgroundTaskId);
		}
	}

	public static SafeClosable setBackgroundTaskIdWithSafeClosable(
		long backgroundTaskId) {

		if (backgroundTaskId > 0) {
			return _backgroundTaskId.setWithSafeClosable(backgroundTaskId);
		}

		return () -> {
		};
	}

	private static final CentralizedThreadLocal<Long> _backgroundTaskId =
		new CentralizedThreadLocal<>(
			BackgroundTaskThreadLocal.class + "._backgroundTaskId", () -> 0L);

}