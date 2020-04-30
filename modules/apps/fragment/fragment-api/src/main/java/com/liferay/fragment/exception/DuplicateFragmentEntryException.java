/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateFragmentEntryException extends PortalException {

	public DuplicateFragmentEntryException() {
	}

	public DuplicateFragmentEntryException(String msg) {
		super(msg);
	}

	public DuplicateFragmentEntryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateFragmentEntryException(Throwable cause) {
		super(cause);
	}

}