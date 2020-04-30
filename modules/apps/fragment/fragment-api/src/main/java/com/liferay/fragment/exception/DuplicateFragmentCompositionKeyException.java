/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateFragmentCompositionKeyException extends PortalException {

	public DuplicateFragmentCompositionKeyException() {
	}

	public DuplicateFragmentCompositionKeyException(String msg) {
		super(msg);
	}

	public DuplicateFragmentCompositionKeyException(
		String msg, Throwable cause) {

		super(msg, cause);
	}

	public DuplicateFragmentCompositionKeyException(Throwable cause) {
		super(cause);
	}

}