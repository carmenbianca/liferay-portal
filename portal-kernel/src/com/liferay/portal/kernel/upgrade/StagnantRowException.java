/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.upgrade;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Alexander Chow
 */
public class StagnantRowException extends PortalException {

	public StagnantRowException(String msg) {
		super(msg);
	}

	public StagnantRowException(String msg, Throwable cause) {
		super(msg, cause);
	}

}