/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.scripting;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Alberto Montero
 * @author Brian Wing Shun Chan
 */
public class ScriptingException extends PortalException {

	public ScriptingException() {
	}

	public ScriptingException(String msg) {
		super(msg);
	}

	public ScriptingException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ScriptingException(Throwable cause) {
		super(cause);
	}

}