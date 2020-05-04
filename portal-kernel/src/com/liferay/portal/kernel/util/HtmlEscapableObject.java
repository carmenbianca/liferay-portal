/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

/**
 * @author Jonathan Potter
 * @author Brian Wing Shun Chan
 */
public class HtmlEscapableObject<T> extends EscapableObject<T> {

	public HtmlEscapableObject(T originalValue) {
		super(originalValue);
	}

	public HtmlEscapableObject(T originalValue, boolean escape) {
		super(originalValue, escape);
	}

	@Override
	protected String escape(T t) {
		return HtmlUtil.escape(String.valueOf(getOriginalValue()));
	}

}