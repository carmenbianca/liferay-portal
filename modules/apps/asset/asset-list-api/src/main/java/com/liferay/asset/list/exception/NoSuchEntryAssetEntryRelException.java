/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.list.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchEntryAssetEntryRelException extends NoSuchModelException {

	public NoSuchEntryAssetEntryRelException() {
	}

	public NoSuchEntryAssetEntryRelException(String msg) {
		super(msg);
	}

	public NoSuchEntryAssetEntryRelException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchEntryAssetEntryRelException(Throwable cause) {
		super(cause);
	}

}