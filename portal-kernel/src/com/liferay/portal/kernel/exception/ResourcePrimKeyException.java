/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class ResourcePrimKeyException extends PortalException {

	public ResourcePrimKeyException() {
	}

	public ResourcePrimKeyException(String msg) {
		super(msg);
	}

	public ResourcePrimKeyException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ResourcePrimKeyException(Throwable cause) {
		super(cause);
	}

}