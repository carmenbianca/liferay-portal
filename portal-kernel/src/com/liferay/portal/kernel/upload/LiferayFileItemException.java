/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.upload;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class LiferayFileItemException extends PortalException {

	public LiferayFileItemException() {
	}

	public LiferayFileItemException(String msg) {
		super(msg);
	}

	public LiferayFileItemException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public LiferayFileItemException(Throwable cause) {
		super(cause);
	}

}