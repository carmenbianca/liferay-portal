/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Hugo Huijser
 */
public class GitException extends PortalException {

	public GitException() {
	}

	public GitException(String msg) {
		super(msg);
	}

	public GitException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public GitException(Throwable cause) {
		super(cause);
	}

}