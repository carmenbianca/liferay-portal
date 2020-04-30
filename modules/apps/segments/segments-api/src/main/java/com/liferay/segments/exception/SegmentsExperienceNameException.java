/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eduardo García
 */
public class SegmentsExperienceNameException extends PortalException {

	public SegmentsExperienceNameException() {
	}

	public SegmentsExperienceNameException(String msg) {
		super(msg);
	}

	public SegmentsExperienceNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SegmentsExperienceNameException(Throwable cause) {
		super(cause);
	}

}