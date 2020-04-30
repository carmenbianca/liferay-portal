/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.social.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class RelationUserIdException extends PortalException {

	public RelationUserIdException() {
	}

	public RelationUserIdException(String msg) {
		super(msg);
	}

	public RelationUserIdException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RelationUserIdException(Throwable cause) {
		super(cause);
	}

}