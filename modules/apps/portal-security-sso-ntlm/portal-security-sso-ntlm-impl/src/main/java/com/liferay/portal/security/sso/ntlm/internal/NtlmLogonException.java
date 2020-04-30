/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.sso.ntlm.internal;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Michael C. Han
 */
public class NtlmLogonException extends SystemException {

	public NtlmLogonException() {
	}

	public NtlmLogonException(String msg) {
		super(msg);
	}

	public NtlmLogonException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NtlmLogonException(Throwable cause) {
		super(cause);
	}

}