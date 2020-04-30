/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sync;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class SyncDeviceHeaderException extends PortalException {

	public SyncDeviceHeaderException() {
	}

	public SyncDeviceHeaderException(String msg) {
		super(msg);
	}

	public SyncDeviceHeaderException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SyncDeviceHeaderException(Throwable cause) {
		super(cause);
	}

}