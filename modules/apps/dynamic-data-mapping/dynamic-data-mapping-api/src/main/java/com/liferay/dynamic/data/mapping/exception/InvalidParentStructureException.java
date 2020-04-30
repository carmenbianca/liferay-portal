/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class InvalidParentStructureException extends PortalException {

	public InvalidParentStructureException() {
	}

	public InvalidParentStructureException(String msg) {
		super(msg);
	}

	public InvalidParentStructureException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public InvalidParentStructureException(Throwable cause) {
		super(cause);
	}

}