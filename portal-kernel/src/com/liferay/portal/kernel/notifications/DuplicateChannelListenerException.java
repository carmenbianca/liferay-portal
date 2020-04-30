/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.notifications;

/**
 * @author Edward Han
 * @author Brian Wing Shun Chan
 */
public class DuplicateChannelListenerException extends ChannelException {

	public DuplicateChannelListenerException() {
	}

	public DuplicateChannelListenerException(String msg) {
		super(msg);
	}

	public DuplicateChannelListenerException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateChannelListenerException(Throwable cause) {
		super(cause);
	}

}