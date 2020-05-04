/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.test;

import com.liferay.portal.kernel.log.Jdk14LogImpl;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.log.LogWrapper;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Shuyang Zhou
 */
public class JDKLoggerTestUtil {

	public static CaptureHandler configureJDKLogger(String name, Level level) {
		LogWrapper logWrapper = (LogWrapper)LogFactoryUtil.getLog(name);

		Log log = logWrapper.getWrappedLog();

		if (!(log instanceof Jdk14LogImpl)) {
			throw new IllegalStateException(
				"Log " + name + " is not a JDK logger");
		}

		Jdk14LogImpl jdk14LogImpl = (Jdk14LogImpl)log;

		Logger logger = jdk14LogImpl.getWrappedLogger();

		CaptureHandler captureHandler = new CaptureHandler(logger, level);

		logger.addHandler(captureHandler);

		return captureHandler;
	}

	static {

		// See LPS-32051 and LPS-32471

		LogFactoryUtil.getLog(JDKLoggerTestUtil.class);
	}

}