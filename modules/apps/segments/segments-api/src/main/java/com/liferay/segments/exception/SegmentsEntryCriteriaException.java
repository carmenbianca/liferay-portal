/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eduardo García
 */
public class SegmentsEntryCriteriaException extends PortalException {

	public SegmentsEntryCriteriaException() {
	}

	public SegmentsEntryCriteriaException(String msg) {
		super(msg);
	}

	public SegmentsEntryCriteriaException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SegmentsEntryCriteriaException(Throwable cause) {
		super(cause);
	}

}