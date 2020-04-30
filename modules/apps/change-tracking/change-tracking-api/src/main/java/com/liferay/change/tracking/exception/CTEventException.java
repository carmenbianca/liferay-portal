/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Shuyang Zhou
 */
public class CTEventException extends PortalException {

	public CTEventException() {
	}

	public CTEventException(String msg) {
		super(msg);
	}

	public CTEventException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CTEventException(Throwable cause) {
		super(cause);
	}

}