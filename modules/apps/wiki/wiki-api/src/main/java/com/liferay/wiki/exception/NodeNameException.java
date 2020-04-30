/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class NodeNameException extends PortalException {

	public NodeNameException() {
	}

	public NodeNameException(String msg) {
		super(msg);
	}

	public NodeNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NodeNameException(Throwable cause) {
		super(cause);
	}

}