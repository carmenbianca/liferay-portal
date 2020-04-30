/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateTeamException extends PortalException {

	public DuplicateTeamException() {
	}

	public DuplicateTeamException(String msg) {
		super(msg);
	}

	public DuplicateTeamException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateTeamException(Throwable cause) {
		super(cause);
	}

}