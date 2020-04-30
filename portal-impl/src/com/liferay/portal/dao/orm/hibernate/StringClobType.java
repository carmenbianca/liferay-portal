/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.orm.hibernate;

import com.liferay.petra.string.StringPool;

import java.util.Objects;

/**
 * @author Shuyang Zhou
 */
@SuppressWarnings("deprecation")
public class StringClobType extends org.hibernate.type.StringClobType {

	@Override
	public boolean equals(Object x, Object y) {
		if (Objects.equals(x, y)) {
			return true;
		}
		else if (((x == null) || x.equals(StringPool.BLANK)) &&
				 ((y == null) || y.equals(StringPool.BLANK))) {

			return true;
		}

		return false;
	}

}