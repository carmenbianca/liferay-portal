/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mobile.device.rules.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Edward C. Han
 */
public class NoSuchRuleGroupException extends NoSuchModelException {

	public NoSuchRuleGroupException() {
	}

	public NoSuchRuleGroupException(String msg) {
		super(msg);
	}

	public NoSuchRuleGroupException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchRuleGroupException(Throwable cause) {
		super(cause);
	}

}