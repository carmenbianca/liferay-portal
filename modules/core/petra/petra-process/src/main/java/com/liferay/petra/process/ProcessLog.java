/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.process;

/**
 * @author Shuyang Zhou
 */
public interface ProcessLog {

	public Level getLevel();

	public String getMessage();

	public Throwable getThrowable();

	public static enum Level {

		// Don't sort, order matters.

		DEBUG, INFO, WARN, ERROR

	}

}