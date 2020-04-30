/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.templateparser;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Alexander Chow
 */
public class TransformException extends PortalException {

	public TransformException() {
	}

	public TransformException(String msg) {
		super(msg);
	}

	public TransformException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public TransformException(Throwable cause) {
		super(cause);
	}

}