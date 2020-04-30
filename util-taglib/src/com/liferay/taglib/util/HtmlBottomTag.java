/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.taglib.util;

import com.liferay.portal.kernel.util.WebKeys;

/**
 * @author Brian Wing Shun Chan
 */
public class HtmlBottomTag extends OutputTag {

	public HtmlBottomTag() {
		super(WebKeys.PAGE_BOTTOM);
	}

}