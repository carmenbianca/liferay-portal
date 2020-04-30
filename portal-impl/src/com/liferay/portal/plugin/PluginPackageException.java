/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.plugin;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Jorge Ferrer
 */
public class PluginPackageException extends SystemException {

	public PluginPackageException() {
	}

	public PluginPackageException(String msg) {
		super(msg);
	}

	public PluginPackageException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PluginPackageException(Throwable cause) {
		super(cause);
	}

}