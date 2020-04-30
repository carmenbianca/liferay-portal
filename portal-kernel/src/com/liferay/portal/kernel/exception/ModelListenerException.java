/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class ModelListenerException extends SystemException {

	public ModelListenerException() {
	}

	public ModelListenerException(String msg) {
		super(msg);
	}

	public ModelListenerException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ModelListenerException(Throwable cause) {
		super(cause);
	}

}