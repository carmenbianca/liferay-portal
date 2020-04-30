/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.talend.common.exception;

/**
 * @author Zoltán Takács
 */
public class MalformedURLException extends RuntimeException {

	public MalformedURLException(String message) {
		super(message);
	}

	public MalformedURLException(Throwable throwable) {
		super(throwable);
	}

}