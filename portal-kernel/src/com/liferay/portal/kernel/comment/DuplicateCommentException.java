/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.comment;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author André de Oliveira
 */
public class DuplicateCommentException extends PortalException {

	public DuplicateCommentException() {
	}

	public DuplicateCommentException(String msg) {
		super(msg);
	}

	public DuplicateCommentException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateCommentException(Throwable cause) {
		super(cause);
	}

}