/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.taglib.ui;

import com.liferay.taglib.util.IncludeTag;

/**
 * @author Roberto Díaz
 */
public class ErrorHeaderTag extends IncludeTag {

	@Override
	protected String getPage() {
		return _PAGE;
	}

	private static final String _PAGE = "/html/taglib/ui/error_header/page.jsp";

}