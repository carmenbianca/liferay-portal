/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.notifications;

/**
 * @author Edward Han
 * @author Brian Wing Shun Chan
 */
public class DuplicateChannelHubException extends ChannelException {

	public DuplicateChannelHubException() {
	}

	public DuplicateChannelHubException(String msg) {
		super(msg);
	}

	public DuplicateChannelHubException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateChannelHubException(Throwable cause) {
		super(cause);
	}

}