/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.settings;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Iván Zaera
 */
public class SettingsException extends PortalException {

	public SettingsException() {
	}

	public SettingsException(String msg) {
		super(msg);
	}

	public SettingsException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SettingsException(Throwable cause) {
		super(cause);
	}

}