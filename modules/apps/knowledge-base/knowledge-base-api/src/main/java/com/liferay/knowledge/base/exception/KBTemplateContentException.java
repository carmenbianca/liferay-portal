/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class KBTemplateContentException extends PortalException {

	public KBTemplateContentException() {
	}

	public KBTemplateContentException(String msg) {
		super(msg);
	}

	public KBTemplateContentException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public KBTemplateContentException(Throwable cause) {
		super(cause);
	}

}