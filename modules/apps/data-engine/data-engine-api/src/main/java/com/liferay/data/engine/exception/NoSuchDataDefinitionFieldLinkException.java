/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.data.engine.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchDataDefinitionFieldLinkException
	extends NoSuchModelException {

	public NoSuchDataDefinitionFieldLinkException() {
	}

	public NoSuchDataDefinitionFieldLinkException(String msg) {
		super(msg);
	}

	public NoSuchDataDefinitionFieldLinkException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchDataDefinitionFieldLinkException(Throwable cause) {
		super(cause);
	}

}