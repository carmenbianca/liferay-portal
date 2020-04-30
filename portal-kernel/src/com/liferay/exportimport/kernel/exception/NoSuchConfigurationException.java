/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchConfigurationException extends NoSuchModelException {

	public NoSuchConfigurationException() {
	}

	public NoSuchConfigurationException(String msg) {
		super(msg);
	}

	public NoSuchConfigurationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchConfigurationException(Throwable cause) {
		super(cause);
	}

}