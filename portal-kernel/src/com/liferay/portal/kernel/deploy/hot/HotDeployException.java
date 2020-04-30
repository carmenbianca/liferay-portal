/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.deploy.hot;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Ivica Cardic
 * @author Brian Wing Shun Chan
 */
public class HotDeployException extends PortalException {

	public HotDeployException() {
	}

	public HotDeployException(String msg) {
		super(msg);
	}

	public HotDeployException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public HotDeployException(Throwable cause) {
		super(cause);
	}

}