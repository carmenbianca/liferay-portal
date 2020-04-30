/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.list.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class AssetListEntryTitleException extends PortalException {

	public AssetListEntryTitleException() {
	}

	public AssetListEntryTitleException(String msg) {
		super(msg);
	}

	public AssetListEntryTitleException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public AssetListEntryTitleException(Throwable cause) {
		super(cause);
	}

}