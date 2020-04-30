/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchPageTemplateStructureException extends NoSuchModelException {

	public NoSuchPageTemplateStructureException() {
	}

	public NoSuchPageTemplateStructureException(String msg) {
		super(msg);
	}

	public NoSuchPageTemplateStructureException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchPageTemplateStructureException(Throwable cause) {
		super(cause);
	}

}