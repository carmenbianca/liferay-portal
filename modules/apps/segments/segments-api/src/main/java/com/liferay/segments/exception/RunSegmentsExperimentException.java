/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eduardo García
 */
public class RunSegmentsExperimentException extends PortalException {

	public RunSegmentsExperimentException() {
	}

	public RunSegmentsExperimentException(String msg) {
		super(msg);
	}

	public RunSegmentsExperimentException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RunSegmentsExperimentException(Throwable cause) {
		super(cause);
	}

}