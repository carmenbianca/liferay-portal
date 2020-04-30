/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.marketplace.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Ryan Park
 */
public class ModuleNamespaceException extends PortalException {

	public ModuleNamespaceException() {
	}

	public ModuleNamespaceException(String msg) {
		super(msg);
	}

	public ModuleNamespaceException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ModuleNamespaceException(Throwable cause) {
		super(cause);
	}

}