/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author José Ángel Jiménez Campoy
 */
public class ExportArticleTargetExtensionException extends PortalException {

	public ExportArticleTargetExtensionException() {
	}

	public ExportArticleTargetExtensionException(String msg) {
		super(msg);
	}

	public ExportArticleTargetExtensionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ExportArticleTargetExtensionException(Throwable cause) {
		super(cause);
	}

}