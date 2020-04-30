/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eduardo García
 */
public class SegmentsExperimentRelNameException extends PortalException {

	public SegmentsExperimentRelNameException() {
	}

	public SegmentsExperimentRelNameException(String msg) {
		super(msg);
	}

	public SegmentsExperimentRelNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SegmentsExperimentRelNameException(Throwable cause) {
		super(cause);
	}

}