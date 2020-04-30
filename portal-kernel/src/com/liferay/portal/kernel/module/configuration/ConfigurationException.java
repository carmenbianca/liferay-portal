/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.module.configuration;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Jürgen Kappler
 * @author Jorge Ferrer
 */
public class ConfigurationException extends PortalException {

	public ConfigurationException() {
	}

	public ConfigurationException(String msg) {
		super(msg);
	}

	public ConfigurationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ConfigurationException(Throwable cause) {
		super(cause);
	}

}