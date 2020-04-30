/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Amos Fong
 */
public class TermsOfUseException extends PortalException {

	public TermsOfUseException() {
	}

	public TermsOfUseException(String msg) {
		super(msg);
	}

	public TermsOfUseException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public TermsOfUseException(Throwable cause) {
		super(cause);
	}

}