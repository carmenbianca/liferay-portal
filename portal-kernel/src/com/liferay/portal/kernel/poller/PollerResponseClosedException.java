/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.poller;

/**
 * @author Edward Han
 */
public class PollerResponseClosedException extends PollerException {

	public PollerResponseClosedException() {
	}

	public PollerResponseClosedException(String msg) {
		super(msg);
	}

	public PollerResponseClosedException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PollerResponseClosedException(Throwable cause) {
		super(cause);
	}

}