/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sync.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class SyncDLObjectChecksumException extends PortalException {

	public SyncDLObjectChecksumException() {
	}

	public SyncDLObjectChecksumException(String msg) {
		super(msg);
	}

	public SyncDLObjectChecksumException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SyncDLObjectChecksumException(Throwable cause) {
		super(cause);
	}

}