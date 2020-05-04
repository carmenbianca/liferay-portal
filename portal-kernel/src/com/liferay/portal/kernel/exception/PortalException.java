/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * The base class for all exceptions related to business logic. Examples include
 * invalid input, portlet errors, and references to non existent database
 * records.
 *
 * <p>
 * Portal exceptions are generally caused by user error, and do not indicate
 * that anything is wrong with the portal itself.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    SystemException
 */
public class PortalException extends NestableException {

	public PortalException() {
	}

	public PortalException(String msg) {
		super(msg);
	}

	public PortalException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PortalException(Throwable cause) {
		super(cause);
	}

}