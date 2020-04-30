/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.upgrade;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class UpgradeException extends PortalException {

	public UpgradeException() {
	}

	public UpgradeException(String msg) {
		super(msg);
	}

	public UpgradeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public UpgradeException(Throwable cause) {
		super(cause);
	}

}