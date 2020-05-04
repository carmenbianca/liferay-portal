/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.taglib.ui;

/**
 * @author     Eudaldo Alonso
 * @deprecated As of Mueller (7.2.x)
 */
@Deprecated
public class OrganizationSearchFormTag<R> extends SearchFormTag<R> {

	@Override
	protected String getPage() {
		return _PAGE;
	}

	private static final String _PAGE =
		"/html/taglib/ui/organization_search_form/page.jsp";

}