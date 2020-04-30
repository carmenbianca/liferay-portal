/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eduardo García
 */
public class SegmentsExperimentGoalException extends PortalException {

	public SegmentsExperimentGoalException() {
	}

	public SegmentsExperimentGoalException(String msg) {
		super(msg);
	}

	public SegmentsExperimentGoalException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SegmentsExperimentGoalException(Throwable cause) {
		super(cause);
	}

}