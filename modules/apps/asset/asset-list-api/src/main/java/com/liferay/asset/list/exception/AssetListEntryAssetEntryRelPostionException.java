/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.list.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class AssetListEntryAssetEntryRelPostionException
	extends PortalException {

	public AssetListEntryAssetEntryRelPostionException() {
	}

	public AssetListEntryAssetEntryRelPostionException(String msg) {
		super(msg);
	}

	public AssetListEntryAssetEntryRelPostionException(
		String msg, Throwable cause) {

		super(msg, cause);
	}

	public AssetListEntryAssetEntryRelPostionException(Throwable cause) {
		super(cause);
	}

}