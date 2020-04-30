/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.poller;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class PollerException extends PortalException {

	public PollerException() {
	}

	public PollerException(String msg) {
		super(msg);
	}

	public PollerException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PollerException(Throwable cause) {
		super(cause);
	}

}