/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.file.rank.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchFileRankException extends NoSuchModelException {

	public NoSuchFileRankException() {
	}

	public NoSuchFileRankException(String msg) {
		super(msg);
	}

	public NoSuchFileRankException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchFileRankException(Throwable cause) {
		super(cause);
	}

}