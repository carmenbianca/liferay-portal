/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.plugin;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author     Brian Wing Shun Chan
 * @deprecated As of Mueller (7.2.x), with no direct replacement
 */
@Deprecated
public class RequiredPluginPackageException extends PortalException {

	public RequiredPluginPackageException() {
	}

	public RequiredPluginPackageException(String msg) {
		super(msg);
	}

	public RequiredPluginPackageException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RequiredPluginPackageException(Throwable cause) {
		super(cause);
	}

	public String getContext() {
		return _context;
	}

	public void setContext(String context) {
		_context = context;
	}

	private String _context;

}