/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class FragmentCollectionNameException extends PortalException {

	public FragmentCollectionNameException() {
	}

	public FragmentCollectionNameException(String msg) {
		super(msg);
	}

	public FragmentCollectionNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public FragmentCollectionNameException(Throwable cause) {
		super(cause);
	}

}