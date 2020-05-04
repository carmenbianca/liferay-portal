/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import java.util.Comparator;

/**
 * @author     Shuyang Zhou
 * @deprecated As of Mueller (7.2.x), with no direct replacement
 */
@Deprecated
public class NullSafeStringComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if (s1 == null) {
			if (s2 == null) {
				return 0;
			}

			return 1;
		}

		if (s2 == null) {
			return -1;
		}

		return s1.compareTo(s2);
	}

}