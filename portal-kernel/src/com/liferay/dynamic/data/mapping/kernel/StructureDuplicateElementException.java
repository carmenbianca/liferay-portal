/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.kernel;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Rafael Praxedes
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