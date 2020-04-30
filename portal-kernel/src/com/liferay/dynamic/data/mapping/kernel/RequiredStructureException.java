/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.kernel;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Rafael Praxedes
 */
public class RequiredStructureException extends PortalException {

	public RequiredStructureException() {
	}

	public RequiredStructureException(String msg) {
		super(msg);
	}

	public RequiredStructureException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RequiredStructureException(Throwable cause) {
		super(cause);
	}

}