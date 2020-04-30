/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.notifications;

/**
 * @author Edward Han
 * @author Brian Wing Shun Chan
 */
public class UnknownChannelHubException extends ChannelException {

	public UnknownChannelHubException() {
	}

	public UnknownChannelHubException(String msg) {
		super(msg);
	}

	public UnknownChannelHubException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public UnknownChannelHubException(Throwable cause) {
		super(cause);
	}

}