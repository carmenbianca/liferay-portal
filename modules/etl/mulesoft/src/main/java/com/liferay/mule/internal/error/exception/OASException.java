/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mule.internal.error.exception;

import com.liferay.mule.internal.error.LiferayError;

import org.mule.runtime.extension.api.exception.ModuleException;

/**
 * @author Matija Petanjek
 */
public class OASException extends ModuleException {

	public OASException(String message) {
		super(message, LiferayError.INVALID_OAS_DOCUMENT);
	}

}