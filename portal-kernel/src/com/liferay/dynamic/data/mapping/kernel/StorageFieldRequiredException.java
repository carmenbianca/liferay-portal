/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.kernel;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Leonardo Barros
 */
public class StorageFieldRequiredException extends PortalException {

	public StorageFieldRequiredException() {
	}

	public StorageFieldRequiredException(String msg) {
		super(msg);
	}

	public StorageFieldRequiredException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public StorageFieldRequiredException(Throwable cause) {
		super(cause);
	}

}