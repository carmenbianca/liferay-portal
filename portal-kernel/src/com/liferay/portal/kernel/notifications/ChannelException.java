/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.notifications;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Edward Han
 * @author Brian Wing Shun Chan
 */
public class ChannelException extends PortalException {

	public ChannelException() {
	}

	public ChannelException(String msg) {
		super(msg);
	}

	public ChannelException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ChannelException(Throwable cause) {
		super(cause);
	}

}