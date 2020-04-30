/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.microsofttranslator;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Hugo Huijser
 */
public class MicrosoftTranslatorException extends PortalException {

	public MicrosoftTranslatorException() {
	}

	public MicrosoftTranslatorException(String msg) {
		super(msg);
	}

	public MicrosoftTranslatorException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public MicrosoftTranslatorException(Throwable cause) {
		super(cause);
	}

}