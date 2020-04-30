/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eduardo García
 */
public class SegmentsEntryKeyException extends PortalException {

	public SegmentsEntryKeyException() {
	}

	public SegmentsEntryKeyException(String msg) {
		super(msg);
	}

	public SegmentsEntryKeyException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SegmentsEntryKeyException(Throwable cause) {
		super(cause);
	}

}