/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sync;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class SyncServicesUnavailableException extends PortalException {

	public SyncServicesUnavailableException() {
	}

	public SyncServicesUnavailableException(String msg) {
		super(msg);
	}

	public SyncServicesUnavailableException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SyncServicesUnavailableException(Throwable cause) {
		super(cause);
	}

}