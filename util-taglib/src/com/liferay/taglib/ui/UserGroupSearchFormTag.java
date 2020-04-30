/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.taglib.ui;

/**
 * @author Eudaldo Alonso
 */
public class UserGroupSearchFormTag<R> extends SearchFormTag<R> {

	@Override
	protected String getPage() {
		return _PAGE;
	}

	private static final String _PAGE =
		"/html/taglib/ui/user_group_search_form/page.jsp";

}