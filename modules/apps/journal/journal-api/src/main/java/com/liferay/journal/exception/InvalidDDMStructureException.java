/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class InvalidDDMStructureException extends PortalException {

	public InvalidDDMStructureException() {
	}

	public InvalidDDMStructureException(String msg) {
		super(msg);
	}

	public InvalidDDMStructureException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public InvalidDDMStructureException(Throwable cause) {
		super(cause);
	}

}