/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class KaleoDefinitionContentException extends PortalException {

	public KaleoDefinitionContentException() {
	}

	public KaleoDefinitionContentException(String msg) {
		super(msg);
	}

	public KaleoDefinitionContentException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public KaleoDefinitionContentException(Throwable cause) {
		super(cause);
	}

}