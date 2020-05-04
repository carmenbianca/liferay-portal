/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class StructureFieldException extends PortalException {

	public StructureFieldException() {
	}

	public StructureFieldException(String msg) {
		super(msg);
	}

	public StructureFieldException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public StructureFieldException(Throwable cause) {
		super(cause);
	}

}