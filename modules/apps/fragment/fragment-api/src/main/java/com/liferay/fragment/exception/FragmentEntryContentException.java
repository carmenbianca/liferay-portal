/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class FragmentEntryContentException extends PortalException {

	public FragmentEntryContentException() {
	}

	public FragmentEntryContentException(String msg) {
		super(msg);
	}

	public FragmentEntryContentException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public FragmentEntryContentException(Throwable cause) {
		super(cause);
	}

}