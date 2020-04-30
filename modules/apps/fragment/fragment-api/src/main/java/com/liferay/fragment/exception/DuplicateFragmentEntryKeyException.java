/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateFragmentEntryKeyException extends PortalException {

	public DuplicateFragmentEntryKeyException() {
	}

	public DuplicateFragmentEntryKeyException(String msg) {
		super(msg);
	}

	public DuplicateFragmentEntryKeyException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateFragmentEntryKeyException(Throwable cause) {
		super(cause);
	}

}