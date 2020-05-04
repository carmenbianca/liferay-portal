/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class AssetTagNameException extends PortalException {

	public AssetTagNameException() {
	}

	public AssetTagNameException(String msg) {
		super(msg);
	}

	public AssetTagNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public AssetTagNameException(Throwable cause) {
		super(cause);
	}

}