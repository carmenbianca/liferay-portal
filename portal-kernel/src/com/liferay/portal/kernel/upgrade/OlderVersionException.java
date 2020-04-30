/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.upgrade;

/**
 * @author Miguel Pastor
 */
public class OlderVersionException extends UpgradeException {

	public OlderVersionException() {
	}

	public OlderVersionException(String msg) {
		super(msg);
	}

	public OlderVersionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public OlderVersionException(Throwable cause) {
		super(cause);
	}

}