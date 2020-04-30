/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class LayoutRevisionMajorException extends PortalException {

	public LayoutRevisionMajorException() {
	}

	public LayoutRevisionMajorException(String msg) {
		super(msg);
	}

	public LayoutRevisionMajorException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public LayoutRevisionMajorException(Throwable cause) {
		super(cause);
	}

}