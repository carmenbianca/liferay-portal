/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.search;

import javax.portlet.RenderResponse;

/**
 * @author Raymond Augé
 */
public class AlwaysTrueRowChecker extends RowChecker {

	public AlwaysTrueRowChecker(RenderResponse renderResponse) {
		super(renderResponse);
	}

	@Override
	public boolean isChecked(Object obj) {
		return true;
	}

}