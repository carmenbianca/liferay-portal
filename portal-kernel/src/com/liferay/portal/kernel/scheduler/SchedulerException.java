/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.scheduler;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Michael C. Han
 * @author Bruno Farache
 */
public class SchedulerException extends PortalException {

	public SchedulerException() {
	}

	public SchedulerException(String msg) {
		super(msg);
	}

	public SchedulerException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SchedulerException(Throwable cause) {
		super(cause);
	}

}