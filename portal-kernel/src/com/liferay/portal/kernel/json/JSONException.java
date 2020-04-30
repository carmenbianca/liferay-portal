/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.json;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class JSONException extends PortalException {

	public JSONException() {
	}

	public JSONException(String msg) {
		super(msg);
	}

	public JSONException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public JSONException(Throwable cause) {
		super(cause);
	}

}