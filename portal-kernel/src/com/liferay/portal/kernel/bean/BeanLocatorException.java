/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.bean;

/**
 * @author Brian Wing Shun Chan
 */
public class BeanLocatorException extends RuntimeException {

	public BeanLocatorException() {
	}

	public BeanLocatorException(String msg) {
		super(msg);
	}

	public BeanLocatorException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public BeanLocatorException(Throwable cause) {
		super(cause);
	}

}