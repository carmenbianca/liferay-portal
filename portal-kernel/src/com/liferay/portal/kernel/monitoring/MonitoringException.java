/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.monitoring;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Michael C. Han
 * @author Brian Wing Shun Chan
 */
public class MonitoringException extends PortalException {

	public MonitoringException() {
	}

	public MonitoringException(String msg) {
		super(msg);
	}

	public MonitoringException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public MonitoringException(Throwable cause) {
		super(cause);
	}

}