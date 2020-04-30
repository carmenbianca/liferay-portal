/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.resources.importer.internal.util;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class ImporterException extends PortalException {

	public ImporterException() {
	}

	public ImporterException(String msg) {
		super(msg);
	}

	public ImporterException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ImporterException(Throwable cause) {
		super(cause);
	}

}