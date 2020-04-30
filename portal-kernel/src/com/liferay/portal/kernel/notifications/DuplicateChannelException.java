/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.notifications;

/**
 * @author Edward Han
 * @author Brian Wing Shun Chan
 */
public class DuplicateChannelException extends ChannelException {

	public DuplicateChannelException() {
	}

	public DuplicateChannelException(String msg) {
		super(msg);
	}

	public DuplicateChannelException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateChannelException(Throwable cause) {
		super(cause);
	}

}