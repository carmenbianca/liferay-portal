/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class StructureDuplicateElementException extends PortalException {

	public StructureDuplicateElementException() {
	}

	public StructureDuplicateElementException(String msg) {
		super(msg);
	}

	public StructureDuplicateElementException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public StructureDuplicateElementException(Throwable cause) {
		super(cause);
	}

}