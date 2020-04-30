/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eudaldo Alonso
 */
public class MaxAddMenuFavItemsException extends PortalException {

	public MaxAddMenuFavItemsException() {
	}

	public MaxAddMenuFavItemsException(String msg) {
		super(msg);
	}

	public MaxAddMenuFavItemsException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public MaxAddMenuFavItemsException(Throwable cause) {
		super(cause);
	}

}