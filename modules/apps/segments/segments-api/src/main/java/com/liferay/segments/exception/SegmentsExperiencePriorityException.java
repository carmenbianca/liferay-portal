/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eduardo García
 */
public class SegmentsExperiencePriorityException extends PortalException {

	public SegmentsExperiencePriorityException() {
	}

	public SegmentsExperiencePriorityException(String msg) {
		super(msg);
	}

	public SegmentsExperiencePriorityException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SegmentsExperiencePriorityException(Throwable cause) {
		super(cause);
	}

}