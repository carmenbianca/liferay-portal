/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.polls.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchVoteException extends NoSuchModelException {

	public NoSuchVoteException() {
	}

	public NoSuchVoteException(String msg) {
		super(msg);
	}

	public NoSuchVoteException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchVoteException(Throwable cause) {
		super(cause);
	}

}