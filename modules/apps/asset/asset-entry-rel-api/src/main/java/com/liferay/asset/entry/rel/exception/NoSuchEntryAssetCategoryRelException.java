/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.entry.rel.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchEntryAssetCategoryRelException extends NoSuchModelException {

	public NoSuchEntryAssetCategoryRelException() {
	}

	public NoSuchEntryAssetCategoryRelException(String msg) {
		super(msg);
	}

	public NoSuchEntryAssetCategoryRelException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchEntryAssetCategoryRelException(Throwable cause) {
		super(cause);
	}

}