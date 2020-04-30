/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateLayoutPageTemplateCollectionTypeException
	extends PortalException {

	public DuplicateLayoutPageTemplateCollectionTypeException() {
	}

	public DuplicateLayoutPageTemplateCollectionTypeException(String msg) {
		super(msg);
	}

	public DuplicateLayoutPageTemplateCollectionTypeException(
		String msg, Throwable cause) {

		super(msg, cause);
	}

	public DuplicateLayoutPageTemplateCollectionTypeException(Throwable cause) {
		super(cause);
	}

}