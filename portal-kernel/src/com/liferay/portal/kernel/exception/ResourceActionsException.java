/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class ResourceActionsException extends PortalException {

	public ResourceActionsException() {
	}

	public ResourceActionsException(String msg) {
		super(msg);
	}

	public ResourceActionsException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ResourceActionsException(Throwable cause) {
		super(cause);
	}

}