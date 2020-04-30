/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchTeamException extends NoSuchModelException {

	public NoSuchTeamException() {
	}

	public NoSuchTeamException(String msg) {
		super(msg);
	}

	public NoSuchTeamException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchTeamException(Throwable cause) {
		super(cause);
	}

}