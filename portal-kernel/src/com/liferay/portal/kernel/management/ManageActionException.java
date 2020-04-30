/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.management;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Shuyang Zhou
 */
public class ManageActionException extends PortalException {

	public ManageActionException() {
	}

	public ManageActionException(String msg) {
		super(msg);
	}

	public ManageActionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ManageActionException(Throwable cause) {
		super(cause);
	}

}