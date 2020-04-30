/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eduardo García
 */
public class SegmentsEntryNameException extends PortalException {

	public SegmentsEntryNameException() {
	}

	public SegmentsEntryNameException(String msg) {
		super(msg);
	}

	public SegmentsEntryNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SegmentsEntryNameException(Throwable cause) {
		super(cause);
	}

}