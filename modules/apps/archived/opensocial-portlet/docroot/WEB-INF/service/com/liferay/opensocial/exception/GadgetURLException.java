/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.opensocial.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class GadgetURLException extends PortalException {

	public GadgetURLException() {
	}

	public GadgetURLException(String msg) {
		super(msg);
	}

	public GadgetURLException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public GadgetURLException(Throwable cause) {
		super(cause);
	}

}