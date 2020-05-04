/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sync.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class SyncDeviceWipeException extends PortalException {

	public SyncDeviceWipeException() {
	}

	public SyncDeviceWipeException(String msg) {
		super(msg);
	}

	public SyncDeviceWipeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SyncDeviceWipeException(Throwable cause) {
		super(cause);
	}

}