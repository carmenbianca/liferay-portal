/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sync;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class SyncSiteUnavailableException extends PortalException {

	public SyncSiteUnavailableException() {
	}

	public SyncSiteUnavailableException(String msg) {
		super(msg);
	}

	public SyncSiteUnavailableException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SyncSiteUnavailableException(Throwable cause) {
		super(cause);
	}

}