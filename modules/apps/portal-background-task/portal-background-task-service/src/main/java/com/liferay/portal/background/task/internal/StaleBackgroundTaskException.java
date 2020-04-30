/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.background.task.internal;

/**
 * @author André de Oliveira
 */
public class StaleBackgroundTaskException extends RuntimeException {

	public StaleBackgroundTaskException(String msg) {
		super(msg);
	}

}