/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class FragmentCompositionNameException extends PortalException {

	public FragmentCompositionNameException() {
	}

	public FragmentCompositionNameException(String msg) {
		super(msg);
	}

	public FragmentCompositionNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public FragmentCompositionNameException(Throwable cause) {
		super(cause);
	}

}