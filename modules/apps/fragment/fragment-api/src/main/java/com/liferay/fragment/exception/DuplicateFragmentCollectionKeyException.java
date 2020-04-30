/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateFragmentCollectionKeyException extends PortalException {

	public DuplicateFragmentCollectionKeyException() {
	}

	public DuplicateFragmentCollectionKeyException(String msg) {
		super(msg);
	}

	public DuplicateFragmentCollectionKeyException(
		String msg, Throwable cause) {

		super(msg, cause);
	}

	public DuplicateFragmentCollectionKeyException(Throwable cause) {
		super(cause);
	}

}