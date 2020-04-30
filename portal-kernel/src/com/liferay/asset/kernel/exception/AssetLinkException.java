/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class AssetLinkException extends PortalException {

	public AssetLinkException() {
	}

	public AssetLinkException(String msg) {
		super(msg);
	}

	public AssetLinkException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public AssetLinkException(Throwable cause) {
		super(cause);
	}

}