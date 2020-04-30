/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class CTCollectionNameException extends PortalException {

	public CTCollectionNameException() {
	}

	public CTCollectionNameException(String msg) {
		super(msg);
	}

	public CTCollectionNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CTCollectionNameException(Throwable cause) {
		super(cause);
	}

}