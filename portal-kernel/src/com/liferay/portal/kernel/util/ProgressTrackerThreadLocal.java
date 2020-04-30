/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import com.liferay.petra.lang.CentralizedThreadLocal;

/**
 * @author Jorge Ferrer
 */
public class ProgressTrackerThreadLocal {

	public static ProgressTracker getProgressTracker() {
		return _progressTracker.get();
	}

	public static void setProgressTracker(ProgressTracker progressTracker) {
		_progressTracker.set(progressTracker);
	}

	private static final ThreadLocal<ProgressTracker> _progressTracker =
		new CentralizedThreadLocal<>(
			ProgressTrackerThreadLocal.class + "._progressTracker");

}