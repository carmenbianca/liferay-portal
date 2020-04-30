/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 * @author Levente Hudák
 */
public class RequiredNodeException extends PortalException {

	public RequiredNodeException() {
	}

	public RequiredNodeException(String msg) {
		super(msg);
	}

	public RequiredNodeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RequiredNodeException(Throwable cause) {
		super(cause);
	}

}