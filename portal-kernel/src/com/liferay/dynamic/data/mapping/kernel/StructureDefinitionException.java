/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.kernel;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Rafael Praxedes
 */
public class StructureDefinitionException extends PortalException {

	public StructureDefinitionException() {
	}

	public StructureDefinitionException(String msg) {
		super(msg);
	}

	public StructureDefinitionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public StructureDefinitionException(Throwable cause) {
		super(cause);
	}

}