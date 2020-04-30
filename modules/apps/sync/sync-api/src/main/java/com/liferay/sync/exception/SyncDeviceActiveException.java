/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sync.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class SyncDeviceActiveException extends PortalException {

	public SyncDeviceActiveException() {
	}

	public SyncDeviceActiveException(String msg) {
		super(msg);
	}

	public SyncDeviceActiveException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SyncDeviceActiveException(Throwable cause) {
		super(cause);
	}

}