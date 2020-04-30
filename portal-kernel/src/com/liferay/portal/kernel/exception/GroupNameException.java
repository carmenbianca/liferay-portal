/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Rubén Pulido
 */
public class GroupNameException extends PortalException {

	public GroupNameException() {
	}

	public GroupNameException(String msg) {
		super(msg);
	}

	public GroupNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public GroupNameException(Throwable cause) {
		super(cause);
	}

}