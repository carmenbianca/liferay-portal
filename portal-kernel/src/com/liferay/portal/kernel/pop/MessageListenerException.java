/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.pop;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class MessageListenerException extends PortalException {

	public MessageListenerException() {
	}

	public MessageListenerException(String msg) {
		super(msg);
	}

	public MessageListenerException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public MessageListenerException(Throwable cause) {
		super(cause);
	}

}