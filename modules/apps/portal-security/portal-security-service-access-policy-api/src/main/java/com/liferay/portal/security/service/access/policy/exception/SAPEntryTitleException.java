/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.service.access.policy.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class SAPEntryTitleException extends PortalException {

	public SAPEntryTitleException() {
	}

	public SAPEntryTitleException(String msg) {
		super(msg);
	}

	public SAPEntryTitleException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SAPEntryTitleException(Throwable cause) {
		super(cause);
	}

}