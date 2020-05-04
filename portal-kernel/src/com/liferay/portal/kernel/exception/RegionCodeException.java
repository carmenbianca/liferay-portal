/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class RegionCodeException extends PortalException {

	public RegionCodeException() {
	}

	public RegionCodeException(String msg) {
		super(msg);
	}

	public RegionCodeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RegionCodeException(Throwable cause) {
		super(cause);
	}

}