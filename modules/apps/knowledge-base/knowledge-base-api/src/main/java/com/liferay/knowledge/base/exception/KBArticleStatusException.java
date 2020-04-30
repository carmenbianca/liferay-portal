/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class KBArticleStatusException extends PortalException {

	public KBArticleStatusException() {
	}

	public KBArticleStatusException(String msg) {
		super(msg);
	}

	public KBArticleStatusException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public KBArticleStatusException(Throwable cause) {
		super(cause);
	}

}