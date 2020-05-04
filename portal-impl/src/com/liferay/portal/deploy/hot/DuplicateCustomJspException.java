/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.deploy.hot;

import com.liferay.portal.kernel.deploy.hot.HotDeployException;

/**
 * @author Zoltán Takács
 */
public class DuplicateCustomJspException extends HotDeployException {

	public DuplicateCustomJspException() {
	}

	public DuplicateCustomJspException(String msg) {
		super(msg);
	}

	public DuplicateCustomJspException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateCustomJspException(Throwable cause) {
		super(cause);
	}

}