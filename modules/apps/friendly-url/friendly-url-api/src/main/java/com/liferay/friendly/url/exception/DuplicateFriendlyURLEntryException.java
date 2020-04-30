/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.friendly.url.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateFriendlyURLEntryException extends PortalException {

	public DuplicateFriendlyURLEntryException() {
	}

	public DuplicateFriendlyURLEntryException(String msg) {
		super(msg);
	}

	public DuplicateFriendlyURLEntryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateFriendlyURLEntryException(Throwable cause) {
		super(cause);
	}

}