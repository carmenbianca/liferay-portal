/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eduardo García
 */
public class SegmentsExperimentConfidenceLevelException
	extends PortalException {

	public SegmentsExperimentConfidenceLevelException() {
	}

	public SegmentsExperimentConfidenceLevelException(String msg) {
		super(msg);
	}

	public SegmentsExperimentConfidenceLevelException(
		String msg, Throwable cause) {

		super(msg, cause);
	}

	public SegmentsExperimentConfidenceLevelException(Throwable cause) {
		super(cause);
	}

}