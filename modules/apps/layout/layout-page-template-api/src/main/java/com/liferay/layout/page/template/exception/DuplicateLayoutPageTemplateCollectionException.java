/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateLayoutPageTemplateCollectionException
	extends PortalException {

	public DuplicateLayoutPageTemplateCollectionException() {
	}

	public DuplicateLayoutPageTemplateCollectionException(String msg) {
		super(msg);
	}

	public DuplicateLayoutPageTemplateCollectionException(
		String msg, Throwable cause) {

		super(msg, cause);
	}

	public DuplicateLayoutPageTemplateCollectionException(Throwable cause) {
		super(cause);
	}

}