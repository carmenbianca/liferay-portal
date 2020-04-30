/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eduardo García
 */
public class SegmentsExperimentRelSplitException extends PortalException {

	public SegmentsExperimentRelSplitException() {
	}

	public SegmentsExperimentRelSplitException(String msg) {
		super(msg);
	}

	public SegmentsExperimentRelSplitException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SegmentsExperimentRelSplitException(Throwable cause) {
		super(cause);
	}

}