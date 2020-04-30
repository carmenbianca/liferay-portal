/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eduardo García
 */
public class SegmentsExperimentNameException extends PortalException {

	public SegmentsExperimentNameException() {
	}

	public SegmentsExperimentNameException(String msg) {
		super(msg);
	}

	public SegmentsExperimentNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SegmentsExperimentNameException(Throwable cause) {
		super(cause);
	}

}