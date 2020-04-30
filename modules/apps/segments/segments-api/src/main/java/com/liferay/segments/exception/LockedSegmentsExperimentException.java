/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eduardo García
 */
public class LockedSegmentsExperimentException extends PortalException {

	public LockedSegmentsExperimentException() {
	}

	public LockedSegmentsExperimentException(long segmentsExperimentId) {
		super("Segments experiment " + segmentsExperimentId + " is locked");
	}

	public LockedSegmentsExperimentException(String msg) {
		super(msg);
	}

	public LockedSegmentsExperimentException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public LockedSegmentsExperimentException(Throwable cause) {
		super(cause);
	}

}