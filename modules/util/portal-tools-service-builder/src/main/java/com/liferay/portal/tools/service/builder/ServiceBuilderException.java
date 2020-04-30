/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.service.builder;

/**
 * @author Raymond Augé
 */
public class ServiceBuilderException extends RuntimeException {

	public ServiceBuilderException(String message) {
		super(message);
	}

	public ServiceBuilderException(String message, Throwable throwable) {
		super(message, throwable);
	}

}