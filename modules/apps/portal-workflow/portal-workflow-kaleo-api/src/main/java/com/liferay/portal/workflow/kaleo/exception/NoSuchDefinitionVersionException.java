/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchDefinitionVersionException extends NoSuchModelException {

	public NoSuchDefinitionVersionException() {
	}

	public NoSuchDefinitionVersionException(String msg) {
		super(msg);
	}

	public NoSuchDefinitionVersionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchDefinitionVersionException(Throwable cause) {
		super(cause);
	}

}