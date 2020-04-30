/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateKaleoDefinitionNameException extends PortalException {

	public DuplicateKaleoDefinitionNameException() {
	}

	public DuplicateKaleoDefinitionNameException(String msg) {
		super(msg);
	}

	public DuplicateKaleoDefinitionNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateKaleoDefinitionNameException(Throwable cause) {
		super(cause);
	}

}