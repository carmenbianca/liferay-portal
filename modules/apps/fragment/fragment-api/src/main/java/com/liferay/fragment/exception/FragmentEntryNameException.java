/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class FragmentEntryNameException extends PortalException {

	public FragmentEntryNameException() {
	}

	public FragmentEntryNameException(String msg) {
		super(msg);
	}

	public FragmentEntryNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public FragmentEntryNameException(Throwable cause) {
		super(cause);
	}

}