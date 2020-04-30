/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.xml;

/**
 * @author Brian Wing Shun Chan
 */
public class DocumentException extends Exception {

	public DocumentException() {
	}

	public DocumentException(String msg) {
		super(msg);
	}

	public DocumentException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DocumentException(Throwable cause) {
		super(cause);
	}

}