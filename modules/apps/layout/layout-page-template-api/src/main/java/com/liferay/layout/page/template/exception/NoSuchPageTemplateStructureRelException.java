/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchPageTemplateStructureRelException
	extends NoSuchModelException {

	public NoSuchPageTemplateStructureRelException() {
	}

	public NoSuchPageTemplateStructureRelException(String msg) {
		super(msg);
	}

	public NoSuchPageTemplateStructureRelException(
		String msg, Throwable cause) {

		super(msg, cause);
	}

	public NoSuchPageTemplateStructureRelException(Throwable cause) {
		super(cause);
	}

}