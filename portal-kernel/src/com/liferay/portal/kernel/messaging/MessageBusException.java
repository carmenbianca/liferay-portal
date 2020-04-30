/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.messaging;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class MessageBusException extends PortalException {

	public MessageBusException() {
	}

	public MessageBusException(String msg) {
		super(msg);
	}

	public MessageBusException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public MessageBusException(Throwable cause) {
		super(cause);
	}

}