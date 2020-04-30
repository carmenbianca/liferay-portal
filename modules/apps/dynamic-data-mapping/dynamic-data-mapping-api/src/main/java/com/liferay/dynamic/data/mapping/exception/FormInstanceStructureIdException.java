/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class FormInstanceStructureIdException extends PortalException {

	public FormInstanceStructureIdException() {
	}

	public FormInstanceStructureIdException(String msg) {
		super(msg);
	}

	public FormInstanceStructureIdException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public FormInstanceStructureIdException(Throwable cause) {
		super(cause);
	}

}