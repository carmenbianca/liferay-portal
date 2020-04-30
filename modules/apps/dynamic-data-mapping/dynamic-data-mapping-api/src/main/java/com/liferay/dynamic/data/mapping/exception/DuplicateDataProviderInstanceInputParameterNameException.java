/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateDataProviderInstanceInputParameterNameException
	extends PortalException {

	public DuplicateDataProviderInstanceInputParameterNameException() {
	}

	public DuplicateDataProviderInstanceInputParameterNameException(
		String msg) {

		super(msg);
	}

	public DuplicateDataProviderInstanceInputParameterNameException(
		String msg, Throwable cause) {

		super(msg, cause);
	}

	public DuplicateDataProviderInstanceInputParameterNameException(
		Throwable cause) {

		super(cause);
	}

}