/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.exception;

import com.liferay.asset.kernel.exception.AssetCategoryException;
import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class KBArticleImportException extends PortalException {

	public KBArticleImportException() {
	}

	public KBArticleImportException(String msg) {
		super(msg);
	}

	public KBArticleImportException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public KBArticleImportException(Throwable cause) {
		super(cause);
	}

	public static class MustHaveACategory extends KBArticleImportException {

		public MustHaveACategory(
			AssetCategoryException assetCategoryException) {

			super(assetCategoryException);
		}

	}

}