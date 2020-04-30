/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class RegionNameException extends PortalException {

	public RegionNameException() {
	}

	public RegionNameException(String msg) {
		super(msg);
	}

	public RegionNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RegionNameException(Throwable cause) {
		super(cause);
	}

}