/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eduardo García
 */
public class WinnerSegmentsExperienceException extends PortalException {

	public WinnerSegmentsExperienceException() {
	}

	public WinnerSegmentsExperienceException(String msg) {
		super(msg);
	}

	public WinnerSegmentsExperienceException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public WinnerSegmentsExperienceException(Throwable cause) {
		super(cause);
	}

}