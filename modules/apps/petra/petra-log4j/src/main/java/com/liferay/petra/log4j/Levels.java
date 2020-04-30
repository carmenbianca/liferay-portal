/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.log4j;

import org.apache.log4j.Level;

/**
 * @author Brian Wing Shun Chan
 */
public class Levels {

	public static final Level[] ALL_LEVELS = {
		Level.OFF, Level.FATAL, Level.ERROR, Level.WARN, Level.INFO,
		Level.DEBUG, Level.TRACE, Level.ALL
	};

}