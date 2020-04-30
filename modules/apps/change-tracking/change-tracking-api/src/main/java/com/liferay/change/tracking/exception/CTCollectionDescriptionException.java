/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class CTCollectionDescriptionException extends PortalException {

	public CTCollectionDescriptionException() {
	}

	public CTCollectionDescriptionException(String msg) {
		super(msg);
	}

	public CTCollectionDescriptionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CTCollectionDescriptionException(Throwable cause) {
		super(cause);
	}

}