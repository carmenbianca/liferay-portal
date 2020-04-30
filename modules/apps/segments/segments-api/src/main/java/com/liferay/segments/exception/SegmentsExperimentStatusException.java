/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eduardo García
 */
public class SegmentsExperimentStatusException extends PortalException {

	public SegmentsExperimentStatusException() {
	}

	public SegmentsExperimentStatusException(String msg) {
		super(msg);
	}

	public SegmentsExperimentStatusException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SegmentsExperimentStatusException(Throwable cause) {
		super(cause);
	}

}