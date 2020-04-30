/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sync;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class SyncClientMinBuildException extends PortalException {

	public SyncClientMinBuildException() {
	}

	public SyncClientMinBuildException(String msg) {
		super(msg);
	}

	public SyncClientMinBuildException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SyncClientMinBuildException(Throwable cause) {
		super(cause);
	}

}