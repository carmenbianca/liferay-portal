/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class VocabularyNameException extends PortalException {

	public VocabularyNameException() {
	}

	public VocabularyNameException(String msg) {
		super(msg);
	}

	public VocabularyNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public VocabularyNameException(Throwable cause) {
		super(cause);
	}

}