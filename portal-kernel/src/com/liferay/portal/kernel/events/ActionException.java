/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.events;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class ActionException extends PortalException {

	public ActionException() {
	}

	public ActionException(String msg) {
		super(msg);
	}

	public ActionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ActionException(Throwable cause) {
		super(cause);
	}

}