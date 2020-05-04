/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.service.access.policy.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class RequiredSAPEntryException extends PortalException {

	public RequiredSAPEntryException() {
	}

	public RequiredSAPEntryException(String msg) {
		super(msg);
	}

	public RequiredSAPEntryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RequiredSAPEntryException(Throwable cause) {
		super(cause);
	}

}