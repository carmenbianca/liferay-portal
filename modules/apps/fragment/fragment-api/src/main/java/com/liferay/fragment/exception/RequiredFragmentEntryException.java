/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class RequiredFragmentEntryException extends PortalException {

	public RequiredFragmentEntryException() {
	}

	public RequiredFragmentEntryException(String msg) {
		super(msg);
	}

	public RequiredFragmentEntryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RequiredFragmentEntryException(Throwable cause) {
		super(cause);
	}

}