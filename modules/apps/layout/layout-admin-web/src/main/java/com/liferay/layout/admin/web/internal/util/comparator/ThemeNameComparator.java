/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.admin.web.internal.util.comparator;

import com.liferay.portal.kernel.model.Theme;

import java.io.Serializable;

import java.util.Comparator;

/**
 * @author Eudaldo Alonso
 */
public class ThemeNameComparator implements Comparator<Theme>, Serializable {

	public ThemeNameComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Theme theme1, Theme theme2) {
		String name1 = theme1.getName();
		String name2 = theme2.getName();

		int value = name1.compareTo(name2);

		if (_ascending) {
			return value;
		}

		return -value;
	}

	private final boolean _ascending;

}