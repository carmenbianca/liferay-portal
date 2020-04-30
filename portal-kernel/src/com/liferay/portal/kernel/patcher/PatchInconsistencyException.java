/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.patcher;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Zoltán Takács
 */
public class PatchInconsistencyException extends PortalException {

	public PatchInconsistencyException() {
	}

	public PatchInconsistencyException(String msg) {
		super(msg);
	}

	public PatchInconsistencyException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PatchInconsistencyException(Throwable cause) {
		super(cause);
	}

}