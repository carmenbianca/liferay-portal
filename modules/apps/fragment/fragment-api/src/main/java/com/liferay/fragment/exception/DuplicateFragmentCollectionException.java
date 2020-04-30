/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateFragmentCollectionException extends PortalException {

	public DuplicateFragmentCollectionException() {
	}

	public DuplicateFragmentCollectionException(String msg) {
		super(msg);
	}

	public DuplicateFragmentCollectionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateFragmentCollectionException(Throwable cause) {
		super(cause);
	}

}