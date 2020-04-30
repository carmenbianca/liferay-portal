/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.data.provider;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Marcellus Tavares
 */
public class DDMDataProviderException extends PortalException {

	public DDMDataProviderException() {
	}

	public DDMDataProviderException(String msg) {
		super(msg);
	}

	public DDMDataProviderException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DDMDataProviderException(Throwable cause) {
		super(cause);
	}

}