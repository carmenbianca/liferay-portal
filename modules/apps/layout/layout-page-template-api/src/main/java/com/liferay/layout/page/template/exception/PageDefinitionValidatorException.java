/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Rubén Pulido
 */
public class PageDefinitionValidatorException extends PortalException {

	public PageDefinitionValidatorException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PageDefinitionValidatorException(Throwable cause) {
		super(cause);
	}

}