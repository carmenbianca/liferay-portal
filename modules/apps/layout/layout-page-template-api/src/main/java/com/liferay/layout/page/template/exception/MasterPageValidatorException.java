/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Rubén Pulido
 */
public class MasterPageValidatorException extends PortalException {

	public MasterPageValidatorException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public MasterPageValidatorException(Throwable cause) {
		super(cause);
	}

}