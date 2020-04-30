/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.deploy.auto;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Ivica Cardic
 * @author Brian Wing Shun Chan
 */
public class AutoDeployException extends PortalException {

	public AutoDeployException() {
	}

	public AutoDeployException(String msg) {
		super(msg);
	}

	public AutoDeployException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public AutoDeployException(Throwable cause) {
		super(cause);
	}

}